package com.example.projecttodolist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public String id;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "time")
    private String time;
    @ColumnInfo(name = "periority")
    private String periority;
    @ColumnInfo(name = "data")
    private String data;

    public UserModel(String date, String time, String periority, String data) {
        this.date = date;
        this.time = time;
        this.periority = periority;
        this.data = data;
    }

    public UserModel(String id, String date, String time, String periority, String data) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.periority = periority;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPeriority() {
        return periority;
    }

    public void setPeriority(String periority) {
        this.periority = periority;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
