package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
/**
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private String userName;

    //database cannot read arraylists, need to convert
    ArrayList<String> head;
    ArrayList<String> body;
    ArrayList<String> hand;

    //progress shown in profile
    @ColumnInfo(name = "progress")
    private double progress;

    public User(String userName, ArrayList<String> head, ArrayList<String> body, ArrayList<String> hand, double progress) {
        this.userName = userName;
        this.head = head;
        this.body = body;
        this.hand = hand;
        this.progress = progress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<String> getHead() {
        return head;
    }

    public void setHead(ArrayList<String> head) {
        this.head = head;
    }

    public ArrayList<String> getBody() {
        return body;
    }

    public void setBody(ArrayList<String> body) {
        this.body = body;
    }

    public ArrayList<String> getHand() {
        return hand;
    }

    public void setHand(ArrayList<String> hand) {
        this.hand = hand;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
**/