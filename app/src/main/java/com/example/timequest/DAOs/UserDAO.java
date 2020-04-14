package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface UserDAO {

    @Query("UPDATE user SET user_hand_item = :handItemName")
    void changeHandItem(String handItemName);

    @Query("UPDATE user SET user_head_item = :headItemName")
    void changeHeadItem(String headItemName);

    @Query("UPDATE user SET user_body_item = :bodyItemName")
    void changeBodyItem(String bodyItemName);

    @Query("UPDATE user SET progress = :newProgress")
    void changeProgress(double newProgress);


    @Query("UPDATE user SET accuracy = :newAccuracy")
    void changeAccuracy(double newAccuracy);


}
