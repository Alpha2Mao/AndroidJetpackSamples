package com.michael.pagingpagekeyeddatasource.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse
{
    @SerializedName("items")
    public List<User> users;

    @SerializedName("has_more")
    public boolean hasMore;

    @Override
    public String toString()
    {
        return "UserResponse{" +
                "users=" + users +
                ", hasMore=" + hasMore +
                '}';
    }
}
