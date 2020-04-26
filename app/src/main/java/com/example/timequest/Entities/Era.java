package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Era {


    @PrimaryKey
    @NonNull
    private String eraName;

    @ColumnInfo(name = "era_banner")
    private String eraBanner;

    @ColumnInfo(name = "era_background")
    private String eraBackground;

    @ColumnInfo(name = "era_completed")
    private String eraCompleted;

    private String eraNotes;
    private String eraYear;

    public Era(String eraName, String eraBanner, String eraBackground, String eraCompleted, String eraNotes, String eraYear) {
        this.eraName = eraName;
        this.eraBanner = eraBanner;
        this.eraBackground = eraBackground;
        this.eraCompleted = eraCompleted;
        this.eraNotes = eraNotes;
        this.eraYear = eraYear;
    }

    public String getEraName() {
        return eraName;
    }

    public void setEraName(String eraName) {
        this.eraName = eraName;
    }

    public String getEraBanner() {
        return eraBanner;
    }

    public void setEraBanner(String eraBanner) {
        this.eraBanner = eraBanner;
    }

    public String getEraBackground() {
        return eraBackground;
    }

    public void setEraBackground(String eraBackground) {
        this.eraBackground = eraBackground;
    }

    public String getEraCompleted() {
        return eraCompleted;
    }

    public void setEraCompleted(String eraCompleted) {
        this.eraCompleted = eraCompleted;
    }

    public String getEraNotes() {
        return eraNotes;
    }

    public void setEraNotes(String eraNotes) {
        this.eraNotes = eraNotes;
    }

    public String getEraYear() {
        return eraYear;
    }

    public void setEraYear(String eraYear) {
        this.eraYear = eraYear;
    }

    public static ArrayList<Era> addEraData() {
        ArrayList<Era> eras = new ArrayList<>();
        eras.add(new Era("Spartan Army", "banner1", "npcathens", "Incomplete", "These are notes for Spartans", "750 BC - 146 BC"));
        eras.add(new Era("Vikings", "banner9", "background9", "Incomplete", "These are notes for Vikings", "793 AD - 1066 AD"));
        eras.add(new Era("Roman Legionnaire", "banner3", "background3", "Incomplete", "These are notes for Roman Legionnaires", "150 BC - 120 BC "));
        eras.add(new Era("Ancient Athenians", "banner4", "background4", "Incomplete", "These are notes for Ancient Athenians", "508 BC - 322 BC "));
        eras.add(new Era("Normans", "banner5", "background5", "Incomplete", "These are notes for Normans", "911 AD - 1167 AD"));
        eras.add(new Era("Cossack Warriors", "banner6", "background6", "Incomplete", "These are notes for Cossack Warriors", "1676 AD - Present"));
        eras.add(new Era("Neanderthals", "banner7", "background7", "Incomplete", "These are notes for Neanderthals", "400 000 BC - 40 000 BC"));
        eras.add(new Era("Qing Dynasty", "banner8", "background8", "Incomplete", "These are notes for Qing Eunuchs", "1636 AD- 1912 AD"));
        eras.add(new Era("North Sentinel Islanders", "banner2", "background2", "Incomplete", "These are notes for North Sentinel Islanders", "60 000 BC - Present"));
        eras.add(new Era("Ancient Egyptians", "banner10", "background10", "Incomplete", "These are notes for Ancient Egyptians", "3100 BC - 30 BC"));

        return eras;
    }


}
