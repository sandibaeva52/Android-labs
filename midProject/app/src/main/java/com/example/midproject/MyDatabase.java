package com.example.midproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Tasks.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract TasksDao tasksDAO();

}
