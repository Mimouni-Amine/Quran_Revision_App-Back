package com.quran.quran_hizb_revision_app.controllers;


import com.quran.quran_hizb_revision_app.Entities.LogRevised;
import com.quran.quran_hizb_revision_app.Entities.MasteryEnum;
import com.quran.quran_hizb_revision_app.Entities.Revision;
import com.quran.quran_hizb_revision_app.Entities.User;
import com.quran.quran_hizb_revision_app.dao.IDAOLogRevised;
import com.quran.quran_hizb_revision_app.dao.IDAORevision;
import com.quran.quran_hizb_revision_app.dao.IDAOUser;
import com.quran.quran_hizb_revision_app.process.RandomProcessImpl;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ControllerMain {


  private IDAORevision idaoRevision;
  private IDAOUser idaoUser;
  private IDAOLogRevised idaoLogRevised;


  //The Current User
  private String currentUser;

  @Autowired
  ControllerMain(IDAORevision idaoRevision, IDAOUser idaoUser, IDAOLogRevised idaoLogRevised) {
    this.idaoRevision = idaoRevision;
    this.idaoUser = idaoUser;
    this.idaoLogRevised = idaoLogRevised;
  }

  @GetMapping("/current-user")
  public void getCurrentUserFromDataBase() {
    //find all by Order Ascending QuartersNumber
    Optional<User> currentUserFound = idaoUser.findById(999);
    this.currentUser = currentUserFound.get().getUserName().substring(1);
    System.out.println(currentUser);
  }

  //TODO: also separate later the pages (Login Folder) (Mode-Choice Folder)
  //TODO: add a rule if user doesn't exist reject (or add menu scroller in react to select from the list of users and send post)
  // , and another method for when adding a new user (will not exist at first)
  @PostMapping(produces = "application/json", path = "/change-user/{userName}")
  public void setCurrentUserInDataBase(@PathVariable("userName") final String userName) {
    //find all by Order Ascending QuartersNumber
    String newUserName = "+" + userName;
    Optional<User> currentUserFound = idaoUser.findById(999);
    currentUserFound.get().setUserName(newUserName);
    User user1 = currentUserFound.get();
    idaoUser.save(user1);
  }

  @GetMapping("/all-quarters")
  public ResponseEntity<List<Revision>> getAllTheQuarters() {
    //find all by Order Ascending QuartersNumber
    List<Revision> myListOfRevisions = idaoRevision.findAllByOrderByQuarterNumberAsc();

    //Return the Get Response
    return new ResponseEntity<>(myListOfRevisions, HttpStatus.OK);
  }


  @GetMapping(produces = "application/json", path = "/all-quartersByUser/")
  public ResponseEntity<List<Revision>> getAllTheQuartersByUser() {
    getCurrentUserFromDataBase();
    //find all by Order Ascending QuartersNumber
    List<Revision> myListOfRevisions = idaoRevision.findAllByRefUserNameOrderByQuarterNumberAsc(
        this.currentUser);

    //Return the Get Response
    return new ResponseEntity<>(myListOfRevisions, HttpStatus.OK);
  }

  //TODO: set it by name ot keep name in memory
  //TODO: Catch if list empty on the other side so i have 999
  //TODO: i did for now by random for bad, next need to have a switch case for using (post parameters) and either urgency-> true
  // (start with it then -> bad -> good -> master....  or give even master ..... plus add mode for revision
  // that I would need to revise (or i can just use urgency for quarters newly learned))

  @GetMapping(produces = "application/json", path = "/automatic-choice-give-revision-to-revise")
  public Revision automaticChoiceGiveRevisionToRevise() {
    getCurrentUserFromDataBase();

    //find all Revisions by Order Ascending QuartersNumber
    List<Revision> myListOfRevisions = idaoRevision.findAllByRefUserNameOrderByQuarterNumberAsc(
        this.currentUser);

    RandomProcessImpl randomProcessImpl = new RandomProcessImpl();

    //Return the Chosen Revision
    Revision chosenRevision = randomProcessImpl.getRandom(myListOfRevisions);
    System.out.println(chosenRevision.getQuarterNumber());
    System.out.println(chosenRevision.getMastery());
    return chosenRevision;
  }


/*  @GetMapping(produces = "application/json", path = "/automatic-choice-give-revision-to-revise")
  public Revision automaticChoiceGiveRevisionToRevise() {
    getCurrentUserFromDataBase();

    Revision revisionToReturn = new Revision();

    //find all by Order Ascending QuartersNumber
    List<Revision> myListOfRevisions = idaoRevision.findAllByRefUserNameOrderByQuarterNumberAsc(
        this.currentUser);

    //by order of urgency
    List<Revision> listMasteryBad = myListOfRevisions.stream()
        .filter(r -> MasteryEnum.Bad.equals(r.getMastery())).collect(Collectors.toList());

    if (!listMasteryBad.isEmpty()) {
      int max = listMasteryBad.size() - 1;
      int min = 0;

      //get random index value
      Random rand = new Random();
      int randomValueOfIndex = rand.nextInt((max - min) + 1) + min;

      revisionToReturn = listMasteryBad.get(randomValueOfIndex);
    }

    //Return the Chosen Revision
    return revisionToReturn;
  }*/

  //TODO: Can use parameters for this
  //TODO: Add Mapper from Revision to LogRevised
  @PostMapping(produces = "application/json", path = "/change-mastery/{quarter}/{mastery}/{timer}")
  public void changeMasteryOfOneRevision(@PathVariable("quarter") final String quarter,
      @PathVariable("mastery") final String mastery,
      @PathVariable("timer") final String timer) {
    getCurrentUserFromDataBase();
    double quarterNumber = Double.parseDouble(quarter);
    //find Revision By Quarter Number
    Revision revision = idaoRevision.findRevisionByQuarterNumberAndAndRefUserName(quarterNumber,
        this.currentUser);

    //Timer
    LocalTime convertedTimer = LocalTime.parse(timer);

    //Generating the LogRevised Object
    LogRevised newLogRevised = new LogRevised();
    //set
    newLogRevised.setDateRevised(LocalDateTime.now());
    newLogRevised.setQuarterNumber(quarterNumber);
    newLogRevised.setRefUserName(this.currentUser);
    newLogRevised.setTimeNeededToFinishRevision(convertedTimer);

    if (revision.getTimeAdded() == null) {
      revision.setTimeAdded(LocalDateTime.now());
    }
    revision.setTimeUpdated(LocalDateTime.now());

//TODO: add revision time Updated
    if (EnumUtils.isValidEnum(MasteryEnum.class, mastery)) {
      revision.setMastery(MasteryEnum.valueOf(mastery));
      newLogRevised.setMastery(MasteryEnum.valueOf(mastery));
    } else {
      //throw exception.
    }
    //update the Revision
    idaoRevision.save(revision);

    //add new LogRevised Object
    idaoLogRevised.save(newLogRevised);
  }

//TODO: need to add Constraints not Null to entity or dto.
  //TODO: check if     LocalTime localTime = LocalTime.parse("01:2");  is on the front cause it will throw an error
}
//TODO: urgency flag to off when day surpasses 2 week after being added
