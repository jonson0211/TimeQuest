package com.example.timequest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.timequest.DAOs.BodyItemsDAO;
import com.example.timequest.DAOs.EraDAO;
import com.example.timequest.DAOs.HandItemsDAO;
import com.example.timequest.DAOs.HeadItemsDAO;

import com.example.timequest.DAOs.UserDAO;
import com.example.timequest.DAOs.WorldQuizDAO;
import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.HandItems;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.User;

@Database(entities = {Era.class, User.class, BodyItems.class, HandItems.class, HeadItems.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

    //public abstract call daos
    public abstract BodyItemsDAO bodyItemsDAO();
    public abstract EraDAO eraDAO();
    public abstract HandItemsDAO handItemsDAO();
    public abstract HeadItemsDAO headItemsDAO();
    public abstract UserDAO userDAO();
    public abstract WorldQuizDAO worldQuizDAO();




    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "TimeQuestDB").allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
