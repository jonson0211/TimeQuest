package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.HandItems;

import java.util.List;

@Dao
public interface HandItemsDAO
{

    //method to insert a hand item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHandItem(HandItems handItem);

    //method to get all user's hand items
    @Query("SELECT * FROM HandItems")
    List<String> getHandItems();

}
