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

    @Query("UPDATE user SET user_hand_item = :handItemName WHERE userID = 1")
    public void changeHandItem(String handItemName);

    @Query("UPDATE user SET user_head_item = :headItemName WHERE userID = 1")
    public void changeHeadItem(String headItemName);

    @Query("UPDATE user SET user_body_item = :bodyItemName WHERE userID = 1")
    public void changeBodyItem(String bodyItemName);

    @Query("UPDATE user SET progress = :newProgress WHERE userID = 1")
    public void changeProgress(double newProgress);


    @Query("UPDATE user SET accuracy = :newAccuracy WHERE userID = 1")
    public void changeAccuracy(double newAccuracy);

    @Query("SELECT user_head_item FROM user WHERE userID = 1")
    public String getHeadItem();

    @Query("SELECT user_body_item FROM user WHERE userID = 1")
    public String getBodyItem();


    @Query("SELECT user_hand_item FROM user WHERE userID = 1")
    public String getHandItem();



}
