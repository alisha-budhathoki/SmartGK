package com.example.smartgk.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Fragment.NewsFragmentPackage.NewsDetailFragment;
import com.example.smartgk.Fragment.NewsFragmentPackage.NewsFragment;
import com.example.smartgk.R;
import com.example.smartgk.model.News;
import com.example.smartgk.utitlies.Constants;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    List<News> mList;
    Context context;
    NewsFragment newsfragment;

    public NewsAdapter(Context context, List<News> mList, NewsFragment newsFragment) {
        this.context = context;
        this.mList = mList;
        this.newsfragment = newsFragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final News news = mList.get(position);
        holder.newsImage.setImageResource(news.getNewsImg());
        holder.newsDate.setText(news.getNewsDate());
        holder.newsDesc.setText(news.getNewsDesc());
        holder.newsTitle.setText(news.getNewsTitle());
        holder.cardNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new NewsDetailFragment();
                FragmentTransaction transaction = newsfragment.getActivity().getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.NEWS_TITLE,holder.newsTitle.getText().toString());
                bundle.putString(Constants.NEWS_DESCRIPTION, holder.newsDesc.getText().toString());
               // Toast.makeText(newsfragment.getContext(), "Sucessfull", Toast.LENGTH_SHORT).show();
                fragment.setArguments(bundle);

                transaction.replace(R.id.main_content, fragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.addToBackStack(null);
                transaction.commit();

                    }
        });
        holder.newsImage.setImageResource(mList.get(position).getNewsImg());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView newsImage;
        TextView newsDate, newsDesc, newsTitle;
        CardView cardNews;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardNews = itemView.findViewById(R.id.cardNews);
            newsImage = (ImageView) itemView.findViewById(R.id.newsImg);
            newsDate = itemView.findViewById(R.id.newsDate);
            newsDesc = itemView.findViewById(R.id.newsDesc);
            newsTitle = itemView.findViewById(R.id.newsTitleGoes);

        }


    }

}