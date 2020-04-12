package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface EraDAO {

    //method to update completion status if the user gets passes the trial
    @Query("UPDATE era SET era_completed = 'Complete' WHERE era_completed = 'Incomplete'")
    void updateToCompleted();

    //method to update completion status if the user gets completes the trial perfectly
    @Query("UPDATE era SET era_completed = 'Perfect'")
    void updateToPerfect();




}
