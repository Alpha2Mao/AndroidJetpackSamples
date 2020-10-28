package com.michael.pagingboundarycallback.paging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.michael.pagingboundarycallback.R;
import com.michael.pagingboundarycallback.model.User;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.UserViewHolder>
{
    private Context context;

    public UserAdapter(Context context)
    {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    /**
     * 用于计算列表中两个非空项之间的差异的回调。
     *
     * 之前数据更新了，需要通过notifyDataSetChanged()通知整个RecyclerView，效率不高
     * 使用DiffUtil只会更新需要更新的Item，不需要刷新整个RecyclerView，并且可以在Item删除的时候加上动画效果
     * */
    private static DiffUtil.ItemCallback<User> DIFF_CALLBACK = new DiffUtil.ItemCallback<User>()
    {
        /**
         * 当DiffUtil想要检测两个对象是否代表同一个Item时，调用该方法进行判断
         * */
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem)
        {
            return oldItem.id == newItem.id;
        }

        /**
         * 当DiffUtil想要检测两个Item是否有一样的数据时，调用该方法进行判断
         *
         * 内容如果更新了，展示给用户看的东西可能也需要更新，所以需要这个判断
         * */
        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem)
        {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position)
    {
        User user = getItem(position);
        if(user != null)
        {
            Picasso.get()
                    .load(user.avatar)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.ivAvatar);

            holder.tvName.setText(user.name);
        }
        else
        {
            holder.ivAvatar.setImageResource(R.drawable.ic_launcher_background);
            holder.tvName.setText("");
        }
    }

    class UserViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivAvatar;
        TextView tvName;

        public UserViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
