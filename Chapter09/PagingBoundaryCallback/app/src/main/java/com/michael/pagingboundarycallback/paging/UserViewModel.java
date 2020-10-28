package com.michael.pagingboundarycallback.paging;

import android.app.Application;
import android.os.AsyncTask;

import com.michael.pagingboundarycallback.db.UserDatabase;
import com.michael.pagingboundarycallback.model.User;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class UserViewModel extends AndroidViewModel
{
    public static final int PER_PAGE = 8;
    /**
     * 通过LivePagedListBuilder创建PagedList，并通过LiveData，将PagedList暴露给页面
     */
    public LiveData<PagedList<User>> userPagedList;

    public UserViewModel(Application application)
    {
        super(application);
        UserDatabase database = UserDatabase.getInstance(application);
        userPagedList = (new LivePagedListBuilder<>(database.userDao().getUserList(), UserViewModel.PER_PAGE))
                .setBoundaryCallback(new UserBoundaryCallback(application))
                .build();
    }

    /**
     * 刷新数据
     */
    public void refresh()
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                UserDatabase.getInstance(getApplication()).userDao().clear();
            }
        });
    }
}
