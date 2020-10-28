package com.michael.databindingdemo.twowaybinding;

import android.os.Bundle;

import com.michael.databindingdemo.R;
import com.michael.databindingdemo.databinding.ActivityTwoWayBindingBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * 演示双向绑定
 * */
public class TwoWayBindingActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityTwoWayBindingBinding activityTwoWayBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding);
        activityTwoWayBindingBinding.setViewModel(new TwoWayBindingViewModel());
    }
}
