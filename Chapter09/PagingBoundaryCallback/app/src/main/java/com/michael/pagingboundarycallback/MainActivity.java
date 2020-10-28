package com.michael.pagingboundarycallback;

import android.os.Bundle;
import android.util.Log;

import com.michael.pagingboundarycallback.model.User;
import com.michael.pagingboundarycallback.paging.UserAdapter;
import com.michael.pagingboundarycallback.paging.UserViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
        final UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.userPagedList.observe(this, new Observer<PagedList<User>>()
        {
            @Override
            public void onChanged(PagedList<User> users)
            {
                Log.e("MainActivity", "onChange()->"+users);
                userAdapter.submitList(users);
            }
        });
        recyclerView.setAdapter(userAdapter);

        final SwipeRefreshLayout swipeRefresh = findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                userViewModel.refresh();
                swipeRefresh.setRefreshing(false);
            }
        });
    }
}
