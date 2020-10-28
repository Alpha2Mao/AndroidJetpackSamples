package com.michael.databindingdemo.smipletextview;

import android.os.Bundle;

import com.michael.databindingdemo.R;
import com.michael.databindingdemo.databinding.ActivitySimpleTextViewBinding;
import com.michael.databindingdemo.model.Book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * 演示简单的TextView绑定
 * */
public class SimpleTextViewActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivitySimpleTextViewBinding activitySimpleTextViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple_text_view);

        Book book = new Book("Android高性能编程", "叶坤");
        book.rating = 5;

        activitySimpleTextViewBinding.setBook(book);//将对象传递到layout中

//        activitySimpleTextViewBinding.setVariable(BR.book, book);//将对象传递到layout中的另外一种设置方式
//        activitySimpleTextViewBinding.tvTitle.setText(book.title);
//        activitySimpleTextViewBinding.tvAuthor.setText(book.author);
    }
}
