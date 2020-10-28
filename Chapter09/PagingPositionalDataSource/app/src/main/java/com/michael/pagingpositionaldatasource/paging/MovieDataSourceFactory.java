package com.michael.pagingpositionaldatasource.paging;

import com.michael.pagingpositionaldatasource.model.Movie;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

/**
 * 通过工厂创建DataSource，并用LiveData包装起来
 * */
public class MovieDataSourceFactory extends DataSource.Factory<Integer, Movie>
{
    private MutableLiveData<MovieDataSource> liveDataSource = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, Movie> create()
    {
        MovieDataSource dataSource = new MovieDataSource();
        liveDataSource.postValue(dataSource);
        return dataSource;
    }
}
