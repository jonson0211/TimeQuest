package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.HeadItems;

import java.util.List;

@Dao
public interface HeadItemsDAO {

    //method to insert head item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHeadItem(HeadItems headItem);

    //method to get all user head items
    @Query("SELECT * FROM HeadItems")
    List<String> getHeadItems();

}
