package com.michael.pagingitemkeyeddatasource.paging;


import com.michael.pagingitemkeyeddatasource.model.User;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class UserDataSourceFactory extends DataSource.Factory<Integer, User>
{
    private MutableLiveData<UserDataSource> liveDataSource = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, User> create()
    {
        UserDataSource dataSource = new UserDataSource();
        liveDataSource.postValue(dataSource);
        return dataSource;
    }
}