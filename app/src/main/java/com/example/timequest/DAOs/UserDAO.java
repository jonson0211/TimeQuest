package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.User;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void insertUser(User user);

    //gets the user's name
    @Query("SELECT user_name FROM user WHERE userID = 1")
    public String getUserName();

    //the following 3 methods update the user's CURRENT handitem, headitem and bodyitem respectively
    @Query("UPDATE user SET user_hand_item = :handItemName WHERE userID = 1")
    public void changeHandItem(String handItemName);

    @Query("UPDATE user SET user_head_item = :headItemName WHERE userID = 1")
    public void changeHeadItem(String headItemName);

    @Query("UPDATE user SET user_body_item = :bodyItemName WHERE userID = 1")
    public void changeBodyItem(String bodyItemName);



    //method to calculate the user's accuracy in answering questions
    @Query("UPDATE user SET accuracy = 100*questionsCorrect/questionsAnswered WHERE userID = 1")
    public void changeAccuracy();

    //getting the user's accuracy
    @Query("SELECT accuracy FROM user WHERE userID = 1")
    public double getAccuracy();



    //getting the user's items
    @Query("SELECT user_head_item FROM user WHERE userID = 1")
    public String getHeadItem();

    @Query("SELECT user_body_item FROM user WHERE userID = 1")
    public String getBodyItem();


    @Query("SELECT user_hand_item FROM user WHERE userID = 1")
    public String getHandItem();


    //these methods track the amount of questions the user answered and has gotten correct, needed to calculate their accuracy
    @Query("UPDATE user SET questionsAnswered = questionsAnswered + :newAnswered WHERE userID = 1")
    public void updateAnswered(double newAnswered);

    @Query("UPDATE user SET questionsCorrect = questionsCorrect + :newCorrect WHERE userID = 1")
    public void updateCorrect(double newCorrect);


}
