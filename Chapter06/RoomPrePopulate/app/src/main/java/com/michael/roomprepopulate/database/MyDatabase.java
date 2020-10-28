package com.michael.roomprepopulate.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, exportSchema = false, version = 1)
public abstract class MyDatabase extends RoomDatabase
{
    private static final String DATABASE_NAME = "my_db";

    private static MyDatabase databaseInstance;

    public static synchronized MyDatabase getInstance(Context context)
    {
        if (databaseInstance == null)
        {
            //从assets/database目录下拷贝读取student.db
            databaseInstance = Room.databaseBuilder(context, MyDatabase.class, DATABASE_NAME)
                    .createFromAsset("databases/students.db")
                    .build();
        }
        return databaseInstance;
    }

    public abstract StudentDao studentDao();
}
