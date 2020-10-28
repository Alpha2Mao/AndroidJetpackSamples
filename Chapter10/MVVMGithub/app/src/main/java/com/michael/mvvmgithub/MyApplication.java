package com.michael.mvvmgithub;

import android.app.Application;

import com.michael.mvvmgithub.api.Api;
import com.michael.mvvmgithub.api.RetrofitClient;
import com.michael.mvvmgithub.db.UserDatabase;

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        userDatabase = UserDatabase.getInstance(this);
        api = RetrofitClient.getInstance().getApi();
    }

    private static UserDatabase userDatabase;
    private static Api api;

    public static Api getApi()
    {
        return api;
    }

    public static UserDatabase getUserDatabase()
    {
        return userDatabase;
    }
}
