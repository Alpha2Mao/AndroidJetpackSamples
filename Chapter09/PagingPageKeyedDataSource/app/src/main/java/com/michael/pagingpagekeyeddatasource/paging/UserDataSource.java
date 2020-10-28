package com.michael.pagingpagekeyeddatasource.paging;

import android.util.Log;

import com.michael.pagingpagekeyeddatasource.api.RetrofitClient;
import com.michael.pagingpagekeyeddatasource.model.User;
import com.michael.pagingpagekeyeddatasource.model.UserResponse;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserDataSource extends PageKeyedDataSource<Integer, User>
{
    public static final int FIRST_PAGE = 1;
    public static final int PER_PAGE = 8;
    public static final String SITE = "stackoverflow";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, User> callback)
    {
        Log.e("loadInitial()", "called");

        RetrofitClient.getInstance()
                .getApi()
                .getUsers(FIRST_PAGE, PER_PAGE, SITE)
                .enqueue(new Callback<UserResponse>()
                {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response)
                    {
                        if(response.body() != null)
                        {
                            Log.e("loadInitial()", " response:"+response.body());
                            callback.onResult(response.body().users, null, FIRST_PAGE+1);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t)
                    {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, User> callback)
    {
        Log.e("loadAfter()", "called");
        RetrofitClient.getInstance()
                .getApi()
                .getUsers(params.key, PER_PAGE, SITE)
                .enqueue(new Callback<UserResponse>()
                {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response)
                    {
                        if(response.body() != null)
                        {
                            Log.e("loadAfter()", " response:"+response.body());
                            Integer nextKey = response.body().hasMore ? params.key + 1 : null;
                            callback.onResult(response.body().users, nextKey);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t)
                    {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, User> callback)
    {
        Log.e("loadBefore()", "called");
    }
}
