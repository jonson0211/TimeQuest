package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.timequest.Entities.BodyItems;

@Dao
public interface BodyItemsDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBodyItem(BodyItems bodyItem);
}
