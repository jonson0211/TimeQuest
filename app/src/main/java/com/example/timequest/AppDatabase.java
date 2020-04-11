package com.example.timequest;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.NPC;
import com.example.timequest.Entities.Notes;
import com.example.timequest.Entities.Trial;
import com.example.timequest.Entities.User;

@Database(entities = {Era.class, Notes.class, NPC.class, Trial.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
}
