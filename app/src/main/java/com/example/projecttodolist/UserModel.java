package com.example.projecttodolist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "date")
    private int date;
    @ColumnInfo(name = "time")
    private int time;
    @ColumnInfo(name = "periority")
    private int periority;

    public UserModel(int date, int time, int periority) {
        this.date = date;
        this.time = time;
        this.periority = periority;
    }

    public UserModel(int id, int date, int time, int periority) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.periority = periority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPeriority() {
        return periority;
    }

    public void setPeriority(int periority) {
        this.periority = periority;
    }
}
