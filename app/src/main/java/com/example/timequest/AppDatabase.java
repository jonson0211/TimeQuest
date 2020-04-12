package com.example.timequest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
/**
import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.NPC;
import com.example.timequest.Entities.Notes;
import com.example.timequest.Entities.Trial;
import com.example.timequest.Entities.User;

@Database(entities = {Era.class, Notes.class, NPC.class, Trial.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //public abstract call daos


    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "timeQuestDatabase").fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
**/