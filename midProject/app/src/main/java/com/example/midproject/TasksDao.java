package com.example.midproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TasksDao {
    @Query("SELECT * FROM tasks")
    List<Tasks> getTasks();

    @Insert
    public void insert(Tasks task);

    @Delete
    public void delete(Tasks task);

    @Update
    public void update(Tasks task);

    @Query("SELECT * FROM tasks WHERE id = :id")
    Tasks getTaskById(int id);
}
