package com.quran.quran_hizb_revision_app.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "log_Revised")
public class LogRevised {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "quarter_number", nullable = false)
  private Double quarterNumber;
  @Enumerated(EnumType.STRING)
  @Column(name = "mastery")
  private MasteryEnum mastery;

  @Column(name = "date_revised")
  private LocalDateTime dateRevised;

  @Column(name = "time_needed_to_finish_revision")
  private LocalTime timeNeededToFinishRevision;

  @Column(name = "ref_username", nullable = false)
  private String refUserName;


  public LogRevised() {

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
   * Public Getter of the quarterNumber
   *
   * @return quarterNumber
   */
  public Double getQuarterNumber() {
    return quarterNumber;
  }

  /**
   * Public Setter of the quarterNumber
   *
   * @param quarterNumber the quarterNumber to set
   */
  public void setQuarterNumber(Double quarterNumber) {
    this.quarterNumber = quarterNumber;
  }

  /**
   * Public Getter of the mastery
   *
   * @return mastery
   */
  public MasteryEnum getMastery() {
    return mastery;
  }

  /**
   * Public Setter of the mastery
   *
   * @param mastery the mastery to set
   */
  public void setMastery(MasteryEnum mastery) {
    this.mastery = mastery;
  }

  /**
   * Public Getter of the dateRevised
   *
   * @return dateRevised
   */
  public LocalDateTime getDateRevised() {
    return dateRevised;
  }

  /**
   * Public Setter of the dateRevised
   *
   * @param dateRevised the dateRevised to set
   */
  public void setDateRevised(LocalDateTime dateRevised) {
    this.dateRevised = dateRevised;
  }

  /**
   * Public Getter of the timeNeededToFinishRevision
   *
   * @return timeNeededToFinishRevision
   */
  public LocalTime getTimeNeededToFinishRevision() {
    return timeNeededToFinishRevision;
  }

  /**
   * Public Setter of the timeNeededToFinishRevision
   *
   * @param timeNeededToFinishRevision the timeNeededToFinishRevision to set
   */
  public void setTimeNeededToFinishRevision(LocalTime timeNeededToFinishRevision) {
    this.timeNeededToFinishRevision = timeNeededToFinishRevision;
  }

  /**
   * Public Getter of the refUserName
   *
   * @return refUserName
   */
  public String getRefUserName() {
    return refUserName;
  }

  /**
   * Public Setter of the refUserName
   *
   * @param refUserName the refUserName to set
   */
  public void setRefUserName(String refUserName) {
    this.refUserName = refUserName;
  }
}
