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

@Entity
@Table(name = "revision")
public class Revision {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "quarter_number", nullable = false)
  private Double quarterNumber;
  @Enumerated(EnumType.STRING)
  @Column(name = "mastery")
  private MasteryEnum mastery;

  @Column(name = "time_updated")
  private LocalDateTime timeUpdated;

  @Column(name = "urgency")
  private boolean urgency;

  @Column(name = "ref_username", nullable = false)
  private String refUserName;

  @Column(name = "time_added")
  private LocalDateTime timeAdded;

  @Column(name = "manually_set_urgency_flag")
  private boolean manuallySetUrgencyFlag;

  @Column(name = "date_of_setting_the_manual_urgency_flag")
  private LocalDateTime dateOfSettingTheManualUrgencyFlag;


  public Revision() {

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
   * Public Getter of the timeUpdated
   *
   * @return timeUpdated
   */
  public LocalDateTime getTimeUpdated() {
    return timeUpdated;
  }

  /**
   * Public Setter of the timeUpdated
   *
   * @param timeUpdated the timeUpdated to set
   */
  public void setTimeUpdated(LocalDateTime timeUpdated) {
    this.timeUpdated = timeUpdated;
  }

  /**
   * Public Getter of the urgency
   *
   * @return urgency
   */
  public boolean isUrgency() {
    return urgency;
  }

  /**
   * Public Setter of the urgency
   *
   * @param urgency the urgency to set
   */
  public void setUrgency(boolean urgency) {
    this.urgency = urgency;
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

  /**
   * Public Getter of the timeAdded
   *
   * @return timeAdded
   */
  public LocalDateTime getTimeAdded() {
    return timeAdded;
  }

  /**
   * Public Setter of the timeAdded
   *
   * @param timeAdded the timeAdded to set
   */
  public void setTimeAdded(LocalDateTime timeAdded) {
    this.timeAdded = timeAdded;
  }

  /**
   * Public Getter of the manuallySetUrgencyFlag
   *
   * @return manuallySetUrgencyFlag
   */
  public boolean isManuallySetUrgencyFlag() {
    return manuallySetUrgencyFlag;
  }

  /**
   * Public Setter of the manuallySetUrgencyFlag
   *
   * @param manuallySetUrgencyFlag the manuallySetUrgencyFlag to set
   */
  public void setManuallySetUrgencyFlag(boolean manuallySetUrgencyFlag) {
    this.manuallySetUrgencyFlag = manuallySetUrgencyFlag;
  }

  /**
   * Public Getter of the dateOfSettingTheManualUrgencyFlag
   *
   * @return dateOfSettingTheManualUrgencyFlag
   */
  public LocalDateTime getDateOfSettingTheManualUrgencyFlag() {
    return dateOfSettingTheManualUrgencyFlag;
  }

  /**
   * Public Setter of the dateOfSettingTheManualUrgencyFlag
   *
   * @param dateOfSettingTheManualUrgencyFlag the dateOfSettingTheManualUrgencyFlag to set
   */
  public void setDateOfSettingTheManualUrgencyFlag(
      LocalDateTime dateOfSettingTheManualUrgencyFlag) {
    this.dateOfSettingTheManualUrgencyFlag = dateOfSettingTheManualUrgencyFlag;
  }
}
