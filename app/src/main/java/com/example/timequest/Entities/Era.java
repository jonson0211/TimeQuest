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
    //"Incomplete", "Complete", "Perfect"
    private String eraCompleted;

    private String eraNotes;

    public Era(String eraName, String eraBanner, String eraBackground, String eraCompleted, String eraNotes) {
        this.eraName = eraName;
        this.eraBanner = eraBanner;
        this.eraBackground = eraBackground;
        this.eraCompleted = eraCompleted;
        this.eraNotes = eraNotes;
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

    public static ArrayList<Era> addEraData(){
        ArrayList<Era> eras = new ArrayList<>();
        eras.add(new Era("Spartan Army", "banner1", "npcathens","Incomplete"," "));
        eras.add(new Era("North Sentinel Islanders", "banner2", "background2","Incomplete", " "));
        eras.add(new Era("Roman Legionnaire", "banner3", "background3","Incomplete", " "));
        eras.add(new Era("Ancient Athenians", "banner4", "background4","Incomplete", " "));
        eras.add(new Era("Normans", "banner5", "background5","Incomplete", " "));
        eras.add(new Era( "Cossack Warriors", "banner6", "background6","Incomplete", " "));
        eras.add(new Era("Neanderthals", "banner7", "background7","Incomplete", " "));
        eras.add(new Era("Qing Dynasty", "banner8", "background8","Incomplete", " "));
        eras.add(new Era("Vikings", "banner9", "background9","Incomplete", " "));

        return eras;
    }



}
