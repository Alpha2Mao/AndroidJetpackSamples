package com.michael.pagingitemkeyeddatasource;

import android.os.Bundle;
import android.util.Log;

import com.michael.pagingitemkeyeddatasource.paging.UserAdapter;
import com.michael.pagingitemkeyeddatasource.model.User;
import com.michael.pagingitemkeyeddatasource.paging.UserViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 获取GitHub用户列表，演示ItemKeyedDataSource的使用方法
 * */
public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final UserAdapter userAdapter = new UserAdapter(this);
        UserViewModel movieViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        movieViewModel.userPagedList.observe(this, new Observer<PagedList<User>>()
        {
            @Override
            public void onChanged(PagedList<User> users)
            {
                Log.e("MainActivity", "onChange()->"+users);
                userAdapter.submitList(users);
            }
        });
        recyclerView.setAdapter(userAdapter);
    }
}

