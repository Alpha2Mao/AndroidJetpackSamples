package com.michael.pagingpositionaldatasource.api;

import com.michael.pagingpositionaldatasource.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api
{
    /**
     * 获取影院当前上映的电影
     *
     * http://api.douban.com/v2/movie/in_theaters?apikey=0df993c66c0c636e29ecbb5344252a4a&start=0&count=10
     * */
    @GET("movie/in_theaters")
    Call<Movies> getMovies
    (
        @Query("start") int since,
        @Query("count") int perPage
    );
}
