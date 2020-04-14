package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface UserDAO {

    @Query("UPDATE user SET user_hand_item = :handItemName")
    public void changeHandItem(String handItemName);

    @Query("UPDATE user SET user_head_item = :headItemName")
    public void changeHeadItem(String headItemName);

    @Query("UPDATE user SET user_body_item = :bodyItemName")
    public void changeBodyItem(String bodyItemName);

    @Query("UPDATE user SET progress = :newProgress")
    public void changeProgress(double newProgress);


    @Query("UPDATE user SET accuracy = :newAccuracy")
    public void changeAccuracy(double newAccuracy);


}
