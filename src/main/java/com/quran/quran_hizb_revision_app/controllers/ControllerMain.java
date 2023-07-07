package com.quran.quran_hizb_revision_app.controllers;


import com.quran.quran_hizb_revision_app.Entities.MasteryEnum;
import com.quran.quran_hizb_revision_app.Entities.Revision;
import com.quran.quran_hizb_revision_app.dao.IDAORevision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControllerMain {

   // @Autowired
    private IDAORevision idaoRevision;

    @Autowired
    ControllerMain (IDAORevision idaoRevision){
        this.idaoRevision = idaoRevision;
    }



    @GetMapping("/all-quarters")
    public ResponseEntity<List<Revision>> getAllTheQuarters(){
        //find all by Order Ascending QuartersNumber
        List<Revision> myListOfRevisions= idaoRevision.findAllByOrderByQuarterNumberAsc();

        //Return the Get Response
        return new ResponseEntity<>(myListOfRevisions, HttpStatus.OK);
    }

    @PostMapping("/change-mastery")
    public void changeMasteryOfOneRevision(){
        //find Revision By Quarter Number
        Revision revision= idaoRevision.findRevisionByQuarterNumber(45.1);
        revision.setMastery(MasteryEnum.Good);
        //update the Revision
        idaoRevision.save(revision);
    }


}
