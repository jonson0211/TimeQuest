package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.HandItems;

@Dao
public interface HandItemsDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHandItem(HandItems handItem);

}
