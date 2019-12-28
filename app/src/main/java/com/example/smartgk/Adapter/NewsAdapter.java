package com.example.smartgk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.R;
import com.example.smartgk.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    List<News> mList;
    Context context;

    public NewsAdapter(Context context, List<News> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final News news = mList.get(position);
        holder.newsImage.setImageResource(news.getNewsImg());
        holder.newsDate.setText(news.getNewsDate());
        holder.newsDesc.setText(news.getNewsDesc());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView newsImage;
        TextView newsDate, newsDesc;

        public MyViewHolder(View itemView) {
            super(itemView);

            newsImage = (ImageView) itemView.findViewById(R.id.newsImg);
            newsDate = itemView.findViewById(R.id.newsDate);
            newsDesc = itemView.findViewById(R.id.newsDesc);
        }


    }

}