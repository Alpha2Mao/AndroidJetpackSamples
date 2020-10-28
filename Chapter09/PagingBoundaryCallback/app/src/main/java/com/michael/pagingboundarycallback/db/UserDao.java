package com.michael.pagingboundarycallback.db;

import com.michael.pagingboundarycallback.model.User;

import java.util.List;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * DAO
 *
 * 对数据库表的增删改查
 *
 * */
@Dao
public interface UserDao
{
    /**
     * 插入数据
     * */
    @Insert
    void insertUsers(List<User> users);

    /**
     * 清空数据
     * */
    @Query("DELETE FROM user")
    void clear();

    /**
     * Room对Paging提供了原生支持，这里直接返回DataSource.Factory，
     * 以便LivePagedListBuilder在创建的时候使用。
     * */
    @Query("SELECT * FROM user")
    DataSource.Factory<Integer, User> getUserList();
}
