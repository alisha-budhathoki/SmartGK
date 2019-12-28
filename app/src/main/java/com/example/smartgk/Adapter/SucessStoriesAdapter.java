package com.example.smartgk.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Actvities.CourseActivity;
import com.example.smartgk.R;
import com.example.smartgk.model.BestCourses;
import com.example.smartgk.model.SucessStories;

import java.util.List;

public class SucessStoriesAdapter extends RecyclerView.Adapter<SucessStoriesAdapter.MyViewHolder> {

    List<SucessStories> mList;
    Context context;

    public SucessStoriesAdapter(Context context, List<SucessStories> mList){
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sucess_stories, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final SucessStories sucessStories =mList.get(position);
        holder.sucessImage.setImageResource(sucessStories.getSucessImg());
        holder.sucessTitle.setText(sucessStories.getSucessName());
        holder.sucessDesc.setText(sucessStories.getSucessDesc());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView sucessImage;
        TextView sucessTitle, sucessDesc;
        CardView cardViewSucess;
        public MyViewHolder(View itemView) {
            super(itemView);

            sucessImage = (ImageView) itemView.findViewById(R.id.sucess_image);
            sucessTitle = itemView.findViewById(R.id.sucess_name);
            sucessDesc = itemView.findViewById(R.id.sucessDesc);
        }


    }

}

