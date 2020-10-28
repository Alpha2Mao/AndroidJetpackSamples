package com.michael.pagingpositionaldatasource.paging;

import android.util.Log;

import com.michael.pagingpositionaldatasource.api.RetrofitClient;
import com.michael.pagingpositionaldatasource.model.Movie;
import com.michael.pagingpositionaldatasource.model.Movies;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDataSource extends PositionalDataSource<Movie>
{

    public static final int PER_PAGE = 8;

    @Override
    public void loadInitial(@NonNull final LoadInitialParams params, @NonNull final LoadInitialCallback<Movie> callback)
    {

        int startPosition = 0;

        RetrofitClient.getInstance()
                .getApi()
                .getMovies(startPosition, PER_PAGE)
                .enqueue(new Callback<Movies>()
                {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response)
                    {
                        if(response.body() != null)
                        {
                            Log.e("loadInitial()", "startPosition:"+params.requestedStartPosition+" response:"+response.body());
                            callback.onResult(response.body().movieList, response.body().start, response.body().total);
                        }
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t)
                    {

                    }
                });
    }

    @Override
    public void loadRange(@NonNull final LoadRangeParams params, @NonNull final LoadRangeCallback<Movie> callback)
    {

        RetrofitClient.getInstance()
                .getApi()
                .getMovies(params.startPosition, PER_PAGE)
                .enqueue(new Callback<Movies>()
                {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response)
                    {
                        if(response.body() != null)
                        {
                            Log.e("loadRange()", "startPosition:" + params.startPosition + " response:" + response.body());
                            callback.onResult(response.body().movieList);
                        }
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t)
                    {

                    }
                });
    }
}
