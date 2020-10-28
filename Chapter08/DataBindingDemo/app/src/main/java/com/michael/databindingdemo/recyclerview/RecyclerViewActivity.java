package com.michael.databindingdemo.recyclerview;

import android.os.Bundle;

import com.michael.databindingdemo.R;
import com.michael.databindingdemo.databinding.ActivityRecyclerviewBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

public class RecyclerViewActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityRecyclerviewBinding activityRecyclerviewBinding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        activityRecyclerviewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityRecyclerviewBinding.recyclerView.setHasFixedSize(true);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(new RecyclerViewViewModel().getBooks());
        activityRecyclerviewBinding.recyclerView.setAdapter(adapter);
    }
}
