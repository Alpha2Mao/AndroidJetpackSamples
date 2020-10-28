package com.michael.mvvmgithub.viewmodel;


import android.app.Application;

import com.michael.mvvmgithub.MyApplication;
import com.michael.mvvmgithub.db.UserDao;
import com.michael.mvvmgithub.db.UserDatabase;
import com.michael.mvvmgithub.model.User;
import com.michael.mvvmgithub.repository.UserRepository;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UserViewModel extends AndroidViewModel
{
    private LiveData<User> user;

    private UserRepository userRepository;

    private String userName = "MichaelYe";

    public UserViewModel(Application application)
    {
        super(application);
        UserDatabase database = MyApplication.getUserDatabase();
        UserDao userDao = database.userDao();
        userRepository = new UserRepository(userDao, MyApplication.getApi());
        user = userRepository.getUser(userName);
    }

    public LiveData<User> getUser()
    {
        return user;
    }

    public void refresh()
    {
        userRepository.refresh(userName);
    }
}
