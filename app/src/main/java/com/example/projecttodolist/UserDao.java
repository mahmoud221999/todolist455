package com.example.projecttodolist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    Void insert(UserModel... UserModels);

    @Query("SELECT*FROM UserModel WHERE periority==0")
    List<UserModel> getHigh();
    @Query("SELECT*FROM UserModel WHERE periority==1")
    List<UserModel> getMediam();
    @Query("SELECT*FROM UserModel WHERE periority==2")
    List<UserModel> getLow();
    @Update
    void update(UserModel UserModel);

    @Delete
    void delete(UserModel UserModel);

}
