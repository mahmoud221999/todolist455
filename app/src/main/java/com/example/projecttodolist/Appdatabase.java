package com.example.projecttodolist;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities =UserModel.class,version = 1,exportSchema = false)

public abstract class Appdatabase extends RoomDatabase {


public  abstract UserDao userDao();
}
