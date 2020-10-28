package com.michael.databindingdemo.eventhandle;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.michael.databindingdemo.R;
import com.michael.databindingdemo.databinding.ActivityEventHandleBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * 通过Button，演示DataBinding如何处理事件
 * */
public class EventHandleActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityEventHandleBinding activityEventHandleBinding = DataBindingUtil.setContentView(this, R.layout.activity_event_handle);
        activityEventHandleBinding.setEventHandler(new EventHandleListener(this));
    }

    /**
     * 这里以内部类的形式放置这个类，将其独立到外面也是可以的。
     *
     * */
    public class EventHandleListener
    {
        private Context context;

        public EventHandleListener(Context context)
        {
            this.context = context;
        }

        public void onButtonClicked(View view)
        {
            Toast.makeText(context, "I am clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
