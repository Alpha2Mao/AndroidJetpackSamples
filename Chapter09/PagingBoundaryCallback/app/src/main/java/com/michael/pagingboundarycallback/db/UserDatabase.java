package com.michael.pagingboundarycallback.db;

import android.content.Context;

import com.michael.pagingboundarycallback.model.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase
{
    private static final String DATABASE_NAME = "user_db";

    private static UserDatabase databaseInstance;

    public static synchronized UserDatabase getInstance(Context context)
    {
        if(databaseInstance == null)
        {
            databaseInstance = Room
                    .databaseBuilder(context.getApplicationContext(), UserDatabase.class, DATABASE_NAME)
                    .build();
        }
        return databaseInstance;
    }

    public abstract UserDao userDao();
}
