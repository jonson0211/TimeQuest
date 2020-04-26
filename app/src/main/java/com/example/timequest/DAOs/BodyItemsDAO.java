package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.BodyItems;

import java.util.List;

@Dao
public interface BodyItemsDAO {


    //method to insert a body item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBodyItem(BodyItems bodyItem);

    //retrieving all body items the user has
    @Query("SELECT * FROM BodyItems")
    List<String> getBodyItems();
}
