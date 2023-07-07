package com.quran.quran_hizb_revision_app.Entities;


import jakarta.persistence.*;


import java.sql.Date;

@Entity
@Table(name = "revision")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Integer id;

    @Column(name = "quarter_number")
    //NOT NULL
    private Float quarterNumber;

    @Column(name = "mastery")
    private String mastery;

    @Column(name = "time_updated")
    private Date timeUpdated;

    @Column(name = "urgency")
    private boolean urgency;

    public Revision(Integer id, Float quarterNumber, String mastery, Date timeUpdated, boolean urgency) {
        this.id = id;
        this.quarterNumber = quarterNumber;
        this.mastery = mastery;
        this.timeUpdated = timeUpdated;
        this.urgency = urgency;
    }

    public Revision() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuarterNumber() {
        return quarterNumber;
    }

    public void setQuarterNumber(Float quarterNumber) {
        this.quarterNumber = quarterNumber;
    }

    public String getMastery() {
        return mastery;
    }

    public void setMastery(String mastery) {
        this.mastery = mastery;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public boolean isUrgency() {
        return urgency;
    }

    public void setUrgency(boolean urgency) {
        this.urgency = urgency;
    }

    //TODO: REimplement MasterEnum
}
