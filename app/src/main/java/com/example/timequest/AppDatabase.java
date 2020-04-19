package com.example.timequest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.timequest.DAOs.BodyItemsDAO;
import com.example.timequest.DAOs.EraDAO;
import com.example.timequest.DAOs.HandItemsDAO;
import com.example.timequest.DAOs.HeadItemsDAO;
import com.example.timequest.DAOs.NotesDAO;
import com.example.timequest.DAOs.UserDAO;
import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.HandItems;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.NPC;
import com.example.timequest.Entities.Notes;
import com.example.timequest.Entities.TrialQuestion;
import com.example.timequest.Entities.User;

@Database(entities = {Era.class, Notes.class, User.class, TrialQuestion.class, BodyItems.class, HandItems.class, HeadItems.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //public abstract call daos
    public abstract BodyItemsDAO bodyItemsDAO();
    public abstract EraDAO eraDAO();
    public abstract HandItemsDAO handItemsDAO();
    public abstract HeadItemsDAO headItemsDAO();
    public abstract NotesDAO notesDAO();
    public abstract UserDAO userDAO();




    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "timeQuestDatabase").fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
