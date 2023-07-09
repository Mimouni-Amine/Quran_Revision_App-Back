package com.quran.quran_hizb_revision_app.Entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "user_name", nullable = false, unique = true)
  private String userName;

  @Column(name = "last_login")
  private LocalDateTime timeOfLastLogin;

  @Column(name = "time_created")
  private LocalDateTime timeCreated;

  @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "ref_username", referencedColumnName = "user_name")
  private List<Revision> revisionsList;

  @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "ref_username", referencedColumnName = "user_name")
  private List<LogRevised> logRevisedList;

  public User() {

  }


  /**
   * Public Getter of the id
   *
   * @return id
   */
  public Integer getId() {
    return id;
  }

  /**
   * Public Setter of the id
   *
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Public Getter of the userName
   *
   * @return userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Public Setter of the userName
   *
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Public Getter of the timeOfLastLogin
   *
   * @return timeOfLastLogin
   */
  public LocalDateTime getTimeOfLastLogin() {
    return timeOfLastLogin;
  }

  /**
   * Public Setter of the timeOfLastLogin
   *
   * @param timeOfLastLogin the timeOfLastLogin to set
   */
  public void setTimeOfLastLogin(LocalDateTime timeOfLastLogin) {
    this.timeOfLastLogin = timeOfLastLogin;
  }

  /**
   * Public Getter of the timeCreated
   *
   * @return timeCreated
   */
  public LocalDateTime getTimeCreated() {
    return timeCreated;
  }

  /**
   * Public Setter of the timeCreated
   *
   * @param timeCreated the timeCreated to set
   */
  public void setTimeCreated(LocalDateTime timeCreated) {
    this.timeCreated = timeCreated;
  }

  /**
   * Public Getter of the revisionsList
   *
   * @return revisionsList
   */
  public List<Revision> getRevisionsList() {
    return revisionsList;
  }

  /**
   * Public Setter of the revisionsList
   *
   * @param revisionsList the revisionsList to set
   */
  public void setRevisionsList(
      List<Revision> revisionsList) {
    this.revisionsList = revisionsList;
  }

  /**
   * Public Getter of the logRevisedList
   *
   * @return logRevisedList
   */
  public List<LogRevised> getLogRevisedList() {
    return logRevisedList;
  }

  /**
   * Public Setter of the logRevisedList
   *
   * @param logRevisedList the logRevisedList to set
   */
  public void setLogRevisedList(
      List<LogRevised> logRevisedList) {
    this.logRevisedList = logRevisedList;
  }
}
