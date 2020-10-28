package com.michael.pagingpagekeyeddatasource.api;


import com.michael.pagingpagekeyeddatasource.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api
{
    /**
     * 获取GitHub用户列表
     *
     * https://api.stackexchange.com/2.2/users?page=1&pagesize=6&site=stackoverflow
     * */
    @GET("users")
    Call<UserResponse> getUsers
    (
        @Query("page") int page,
        @Query("pagesize") int pageSize,
        @Query("site") String site
    );
}
