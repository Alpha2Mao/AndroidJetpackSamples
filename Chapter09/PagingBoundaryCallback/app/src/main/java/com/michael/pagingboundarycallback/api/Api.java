package com.michael.pagingboundarycallback.api;

import com.michael.pagingboundarycallback.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api
{
    /**
     * 获取GitHub用户列表
     *
     * https://api.github.com/users?since=0&page=0&per_page=5
     *
     * @param since 这里的since是上一个列表中最后一个User的id，以这个id作为since的值，请求下一列表的数据
     * */
    @GET("users")
    Call<List<User>> getUsers
    (
            @Query("since") int since,
            @Query("per_page") int perPage
    );
}
