package com.michael.databindingdemo.recyclerview;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import com.michael.databindingdemo.R;
import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class RecyclerViewImageBindingAdapter
{
    /**
     * 加载网络图片
     * */
    @BindingAdapter("itemImage")
    public static void setImage(ImageView imageView, String imageUrl)
    {
        if(!TextUtils.isEmpty(imageUrl))
        {
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);
        }
        else
        {
            imageView.setBackgroundColor(Color.DKGRAY);
        }
    }
}
