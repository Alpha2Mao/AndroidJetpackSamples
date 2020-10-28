package com.michael.pagingboundarycallback.paging;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.michael.pagingboundarycallback.api.RetrofitClient;
import com.michael.pagingboundarycallback.db.UserDatabase;
import com.michael.pagingboundarycallback.model.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserBoundaryCallback extends PagedList.BoundaryCallback<User>
{
    private String TAG = this.getClass().getName();
    private Application application;

    public UserBoundaryCallback(Application application)
    {
        this.application = application;
    }

    @Override
    public void onZeroItemsLoaded()
    {
        super.onZeroItemsLoaded();
        Log.e(TAG, "onZeroItemsLoaded()");
        getTopData();
    }

    @Override
    public void onItemAtFrontLoaded(@NonNull User itemAtFront)
    {
        super.onItemAtFrontLoaded(itemAtFront);
        Log.e(TAG, "onItemAtFrontLoaded()");
    }

    @Override
    public void onItemAtEndLoaded(@NonNull User itemAtEnd)
    {
        super.onItemAtEndLoaded(itemAtEnd);
        Log.e(TAG, "onItemAtEndLoaded()");
        getTopAfterData(itemAtEnd);
    }

    /**
     * 没有数据的时候，加载第一页数据
     */
    private void getTopData()
    {
        int since = 0;
        RetrofitClient.getInstance()
                .getApi()
                .getUsers(since, UserViewModel.PER_PAGE)
                .enqueue(new Callback<List<User>>()
                {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response)
                    {
                        if (response.body() != null)
                        {
                            Log.e("getTopData()", " response:" + response.body());
                            insertUsers(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t)
                    {

                    }
                });
    }

    /**
     * 获取下一页数据
     */
    private void getTopAfterData(User user)
    {
        RetrofitClient.getInstance()
                .getApi()
                .getUsers(user.id, UserViewModel.PER_PAGE)
                .enqueue(new Callback<List<User>>()
                {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response)
                    {
                        if (response.body() != null)
                        {
                            Log.e("getTopAfterData()", " response:" + response.body());
                            insertUsers(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t)
                    {

                    }
                });
    }

    /**
     * 插入数据
     */
    private void insertUsers(final List<User> users)
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                UserDatabase.getInstance(application).userDao().insertUsers(users);
            }
        });
    }
}
