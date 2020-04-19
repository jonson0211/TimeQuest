package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.timequest.Entities.HeadItems;

@Dao
public interface HeadItemsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHeadItem(HeadItems headItem);

}
