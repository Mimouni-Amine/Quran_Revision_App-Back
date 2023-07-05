package com.quran.quran_hizb_revision_app.Entities;

public enum MasteryEnum {
    Bad("many Mistakes Not Good"),
    Average("With Mushaf sometimes"),
    Good("without mushaf most of the time"),
    Master("No need for the mushaf Everything is in my Brain");

    private final String value;

    MasteryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
