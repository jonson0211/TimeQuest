package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface BodyItemsDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBodyItem(String bodyItem);
}
