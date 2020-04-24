package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {

    @PrimaryKey
    @NonNull
    private int userID;

    //progress
    @ColumnInfo(name = "user_name")
    private String userName;

    //progress shown in profile
    @ColumnInfo(name = "progress")
    private double progress;

    //progress shown in profile
    @ColumnInfo(name = "accuracy")
    private double accuracy;

    @ColumnInfo(name = "user_head_item")
    private String userHeadItem;

    @ColumnInfo(name = "user_hand_item")
    private String userHandItem;

    @ColumnInfo(name = "user_body_item")
    private String userBodyItem;

    private double questionsCorrect;

    private double questionsAnswered;

    public int getUserID() {
        return userID;
    }

    public User(int userID, String userName, double progress, double accuracy, String userHeadItem, String userHandItem, String userBodyItem, double questionsCorrect, double questionsAnswered) {
        this.userID = userID;
        this.userName = userName;
        this.progress = progress;
        this.accuracy = accuracy;
        this.userHeadItem = userHeadItem;
        this.userHandItem = userHandItem;
        this.userBodyItem = userBodyItem;
        this.questionsCorrect = questionsCorrect;
        this.questionsAnswered = questionsAnswered;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getUserHeadItem() {
        return userHeadItem;
    }

    public void setUserHeadItem(String userHeadItem) {
        this.userHeadItem = userHeadItem;
    }

    public String getUserHandItem() {
        return userHandItem;
    }

    public void setUserHandItem(String userHandItem) {
        this.userHandItem = userHandItem;
    }

    public String getUserBodyItem() {
        return userBodyItem;
    }

    public void setUserBodyItem(String userBodyItem) {
        this.userBodyItem = userBodyItem;
    }

    public double getQuestionsCorrect() {
        return questionsCorrect;
    }

    public void setQuestionsCorrect(double questionsCorrect) {
        this.questionsCorrect = questionsCorrect;
    }

    public double getQuestionsAnswered() {
        return questionsAnswered;
    }

    public void setQuestionsAnswered(double questionsAnswered) {
        this.questionsAnswered = questionsAnswered;
    }
}
