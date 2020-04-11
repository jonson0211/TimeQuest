package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NPC {

    @PrimaryKey
    @NonNull
    private int npcID;

    private String npcName;

    //what the NPC greets the user with
    private String welcomeSpeech;

    //what the NPC says to the user if they beat the trial
    private String endingSpeech;

    //what the NPC says to the user if they fail the trial
    private String failSpeech;

    //what they look like
    private String npcAvatar;


    public NPC(int npcID, String npcName, String welcomeSpeech, String endingSpeech, String failSpeech, String npcAvatar) {
        this.npcID = npcID;
        this.npcName = npcName;
        this.welcomeSpeech = welcomeSpeech;
        this.endingSpeech = endingSpeech;
        this.failSpeech = failSpeech;
        this.npcAvatar = npcAvatar;
    }

    public int getNpcID() {
        return npcID;
    }

    public void setNpcID(int npcID) {
        this.npcID = npcID;
    }

    public String getNpcName() {
        return npcName;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public String getWelcomeSpeech() {
        return welcomeSpeech;
    }

    public void setWelcomeSpeech(String welcomeSpeech) {
        this.welcomeSpeech = welcomeSpeech;
    }

    public String getEndingSpeech() {
        return endingSpeech;
    }

    public void setEndingSpeech(String endingSpeech) {
        this.endingSpeech = endingSpeech;
    }

    public String getFailSpeech() {
        return failSpeech;
    }

    public void setFailSpeech(String failSpeech) {
        this.failSpeech = failSpeech;
    }

    public String getNpcAvatar() {
        return npcAvatar;
    }

    public void setNpcAvatar(String npcAvatar) {
        this.npcAvatar = npcAvatar;
    }
}
