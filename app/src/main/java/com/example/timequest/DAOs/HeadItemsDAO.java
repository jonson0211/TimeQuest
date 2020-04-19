package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface HeadItemsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHeadItem(String headItem);

}
