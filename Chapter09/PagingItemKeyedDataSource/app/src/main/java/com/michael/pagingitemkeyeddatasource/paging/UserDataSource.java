package com.michael.pagingitemkeyeddatasource.paging;

import android.util.Log;

import com.michael.pagingitemkeyeddatasource.api.RetrofitClient;
import com.michael.pagingitemkeyeddatasource.model.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataSource extends ItemKeyedDataSource<Integer, User>
{

    public static final int PER_PAGE = 12;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<User> callback)
    {
        Log.e("loadInitial()", "called");

        int since = 0;

        RetrofitClient.getInstance()
                .getApi()
                .getUsers(since, PER_PAGE)
                .enqueue(new Callback<List<User>>()
                {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response)
                    {
                        if(response.body() != null)
                        {
                            Log.e("loadInitial()", " response:"+response.body());
                            callback.onResult(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t)
                    {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull final LoadCallback<User> callback)
    {
        Log.e("loadAfter()", "called");
        RetrofitClient.getInstance()
                .getApi()
                .getUsers(params.key, PER_PAGE)
                .enqueue(new Callback<List<User>>()
                {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response)
                    {
                        if(response.body() != null)
                        {
                            Log.e("loadAfter()", " response:"+response.body());
                            callback.onResult(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t)
                    {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<User> callback)
    {
        Log.e("loadBefore()", "called");
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull User user)
    {
        Log.e("getkey()", "called");

        return user.id;
    }
}
