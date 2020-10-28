package com.michael.databindingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.michael.databindingdemo.bindingadapter.BindingAdapterActivity;
import com.michael.databindingdemo.eventhandle.EventHandleActivity;
import com.michael.databindingdemo.includelayout.IncludeLayoutActivity;
import com.michael.databindingdemo.recyclerview.RecyclerViewActivity;
import com.michael.databindingdemo.smipletextview.SimpleTextViewActivity;
import com.michael.databindingdemo.twowaybinding.TwoWayBindingActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleTextViewButtonClicked(View view)
    {
        Intent intent = new Intent(this, SimpleTextViewActivity.class);
        startActivity(intent);
    }

    public void EventHandleButtonClicked(View view)
    {
        Intent intent = new Intent(this, EventHandleActivity.class);
        startActivity(intent);
    }

    public void IncludeLayoutButtonClicked(View view)
    {
        Intent intent = new Intent(this, IncludeLayoutActivity.class);
        startActivity(intent);
    }

    public void BindingAdapterButtonClicked(View view)
    {
        Intent intent = new Intent(this, BindingAdapterActivity.class);
        startActivity(intent);
    }

    public void TwoWayBindingButtonClicked(View view)
    {
        Intent intent = new Intent(this, TwoWayBindingActivity.class);
        startActivity(intent);
    }

    public void RecyclerViewButtonClicked(View view)
    {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}
