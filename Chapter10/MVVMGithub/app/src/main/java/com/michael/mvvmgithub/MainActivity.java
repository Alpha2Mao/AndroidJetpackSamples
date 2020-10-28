package com.michael.mvvmgithub;

import android.os.Bundle;
import android.util.Log;

import com.michael.mvvmgithub.databinding.ActivityMainBinding;
import com.michael.mvvmgithub.model.User;
import com.michael.mvvmgithub.viewmodel.UserViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<User>()
        {
            @Override
            public void onChanged(User user)
            {
                Log.e("MainActivity->onChanged", "user:"+user);
                if(user != null)
                {
                    activityMainBinding.setUser(user);
                }
            }
        });

        final SwipeRefreshLayout swipeRefresh = activityMainBinding.swipeRefresh;
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
