package com.michael.databindingdemo.recyclerview;

import com.michael.databindingdemo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewViewModel
{
    public List<Book> getBooks()
    {
        List<Book> books = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            Book book = new Book("Android高性能编程"+i, "叶坤"+i);
            book.image = "https://img1.doubanio.com/view/subject/l/public/s29670267.jpg";
            books.add(book);
        }
        return books;
    }
}
