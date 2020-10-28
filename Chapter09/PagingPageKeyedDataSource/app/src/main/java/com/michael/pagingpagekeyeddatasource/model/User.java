package com.michael.pagingpagekeyeddatasource.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


public class User
{
    @SerializedName("account_id")
    public int id;

    @SerializedName("display_name")
    public String name;

    @SerializedName("profile_image")
    public String avatar;

    public User(int id, String name, String avatar)
    {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                avatar.equals(user.avatar);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, avatar);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
