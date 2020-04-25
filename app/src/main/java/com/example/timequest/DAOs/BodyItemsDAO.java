package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.BodyItems;

import java.util.List;

@Dao
public interface BodyItemsDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBodyItem(BodyItems bodyItem);

    @Query("SELECT * FROM BodyItems")
    List<String> getBodyItems();
}
