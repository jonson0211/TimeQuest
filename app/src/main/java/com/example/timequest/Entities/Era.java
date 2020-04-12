package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Era {

    @PrimaryKey(autoGenerate = true)
    private int eraID;

    @ColumnInfo(name = "era_name")
    private String eraName;

    @ColumnInfo(name = "era_banner")
    private String eraBanner;

    @ColumnInfo(name = "era_background")
    private String eraBackground;

    @ColumnInfo(name = "era_completed")
    //"Incomplete", "Complete", "Perfect"
    private String eraCompleted;


    public Era(int eraID, String eraName, String eraBanner, String eraBackground, String eraCompleted) {
        this.eraID = eraID;
        this.eraName = eraName;
        this.eraBanner = eraBanner;
        this.eraBackground = eraBackground;
        this.eraCompleted = eraCompleted;
    }

    public int getEraID() {
        return eraID;
    }

    public void setEraID(int eraID) {
        this.eraID = eraID;
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

    public static ArrayList<Era> addEraData(){
        ArrayList<Era> eras = new ArrayList<>();
        eras.add(new Era(1, "Spartan Army", "banner1", "background1","Incomplete"));
        eras.add(new Era(2, "North Sentinel Islanders", "banner2", "background2","Incomplete"));
        eras.add(new Era(3, "Roman Legionnaire", "banner3", "background3","Incomplete"));
        eras.add(new Era(4, "Ancient Athenian", "banner4", "background4","Incomplete"));
        eras.add(new Era(5, "Normans", "banner5", "background5","Incomplete"));
        eras.add(new Era(6, "Cossack Warriors", "banner6", "background6","Incomplete"));
        eras.add(new Era(7, "Neanderthals", "banner7", "background7","Incomplete"));
        eras.add(new Era(8, "Qing Dynasty", "banner8", "background8","Incomplete"));
        eras.add(new Era(9, "Vikings", "banner9", "background9","Incomplete"));

        return eras;
    }



}
