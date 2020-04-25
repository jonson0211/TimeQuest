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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHeadItem(HeadItems headItem);

    @Query("SELECT * FROM HeadItems")
    List<String> getHeadItems();

}
