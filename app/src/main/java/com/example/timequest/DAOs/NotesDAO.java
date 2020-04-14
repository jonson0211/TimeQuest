package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.Notes;

import java.util.List;

@Dao
public interface NotesDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNote (Notes note);


    @Delete
    public void deleteNote (Notes note);


    @Query("SELECT * FROM Notes")
    List<Notes> getNotes();
}
