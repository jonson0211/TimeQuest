package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private String userName;

    //progress shown in profile
    @ColumnInfo(name = "progress")
    private double progress;

    //progress shown in profile
    @ColumnInfo(name = "accuracy")
    private double accuracy;

    public User(String userName, double progress, double accuracy) {
        this.userName = userName;
        this.progress = progress;
        this.accuracy = accuracy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
