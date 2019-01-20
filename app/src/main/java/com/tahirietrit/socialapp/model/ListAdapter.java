package com.tahirietrit.socialapp.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tahirietrit.socialapp.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater infalter;
    ArrayList<Posts> posts;
    Intent intent;

    public static final String USERNAME_MESSAGE = "username_text";
    public static final String AGOTIME_MESSAGE = "lastname_text";
    //public static final String TEL_MESSAGE = "tel_text";
    //public static final String IMAGEINTR_MESSAGE = "imageIntR_text";

    public void setPosts(ArrayList<Posts> posts) {
        this.posts = posts;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public ListAdapter(Context ctx, LayoutInflater inflater) {
        this.ctx = ctx;
        this.infalter = inflater;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = infalter.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.username.setText(posts.get(position).getUsername());
        holder.agoTime.setText(posts.get(position).getCreatedDate());

        holder.listItemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(USERNAME_MESSAGE, posts.get(position).getUsername());
                intent.putExtra(AGOTIME_MESSAGE, posts.get(position).getCreatedDate());

                ctx.startActivity(intent);
            }
        });

        return convertView;
    }


    class ViewHolder {
        ImageView profiliImageView;
        TextView username;
        TextView agoTime;
        LinearLayout listItemLinearLayout;

        public ViewHolder(View view) {
            username = view.findViewById(R.id.username_TextView);
            agoTime = view.findViewById(R.id.ago_TextView);
            profiliImageView = view.findViewById(R.id.profili_ImageView);
            listItemLinearLayout = view.findViewById(R.id.list_item_LinearLayout);
        }
    }
}