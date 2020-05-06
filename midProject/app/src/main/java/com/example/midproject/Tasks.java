package com.example.midproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//@Entity(foreignKeys = @ForeignKey(entity=Tasks.class,parentColumns = "ID",childColumns = "category",))
@Entity(tableName = "tasks")
public class Tasks implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int ID;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "status")
    public String status;
    @ColumnInfo(name = "category")
    public String category;
    @ColumnInfo(name = "durations")
    public int durations;

public Tasks(){
    this.ID=ID;
    this.title=title;
    this.description=description;
    this.status=status;
    this.category=category;
    this.durations=durations;
}
    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public String getTitle(){
    return title;
    }
    public void setTitle(String title){
    this.title=title;
    }
    public String getDescription( ){
    return description;
    }
    public void setDescription(String description){
    this.description=description;
    }
    public String getStatus(){
    return status;
    }
    public void setStatus(String status){
    this.status=status;
    }
    public String getCategory(){
    return category;
    }
    public void setCategory(String category){
    this.category=category;
    }
    public int getDurations(){
    return durations;
    }
    public void setDurations(int durations){
    this.durations=durations;
    }



}
