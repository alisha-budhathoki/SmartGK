package com.example.smartgk.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities =  UserDetails.class, version = 1, exportSchema = false)
public abstract class SmartGkDatabase extends RoomDatabase {
    private static final String DB_NAME = "smartGkDB.db";
    private static volatile SmartGkDatabase instance;

    public static synchronized SmartGkDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static SmartGkDatabase create(final Context context) {
        return Room.databaseBuilder(context,
                SmartGkDatabase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public abstract UserDetailDao userDetailDao();
;


}
