package com.michael.databindingdemo.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.michael.databindingdemo.R;
import com.michael.databindingdemo.databinding.LayoutItemBinding;
import com.michael.databindingdemo.model.Book;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
    private List<Book> books;

    public RecyclerViewAdapter(List<Book> books)
    {
        this.books = books;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutItemBinding layoutItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.layout_item, parent,false);

        return new MyViewHolder(layoutItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Book book = books.get(position);
        holder.layoutItemBinding.setBook(book);
    }

    @Override
    public int getItemCount()
    {
        return books.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        LayoutItemBinding layoutItemBinding;

        public MyViewHolder(@NonNull LayoutItemBinding itemView)
        {
            super(itemView.getRoot());//getRoot()返回的是布局文件的最外层UI视图
            layoutItemBinding = itemView;
        }
    }
}
