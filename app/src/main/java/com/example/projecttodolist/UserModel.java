package com.example.projecttodolist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "time")
    private String time;
    @ColumnInfo(name = "periority")
    private int periority;
    @ColumnInfo(name = "data")
    private String data;

    public UserModel(String date, String time, int periority, String data) {
        this.date = date;
        this.time = time;
        this.periority = periority;
        this.data = data;
    }

@Ignore
    public UserModel(int id, String date, String time, int periority, String data) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.periority = periority;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPeriority() {
        return periority;
    }

    public void setPeriority(int periority) {
        this.periority = periority;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
