package com.michael.mvvmgithub.bindingadapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.michael.mvvmgithub.R;
import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class ImageViewBindingAdapter
{
    /**
     * 加载网络图片，多个参数的情况
     * */
    @BindingAdapter(value = {"image", "defaultImageResource"}, requireAll = false)
    public static void setImage(ImageView imageView, String imageUrl, int imageResource)
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
            imageView.setImageResource(imageResource);
        }
    }
}
