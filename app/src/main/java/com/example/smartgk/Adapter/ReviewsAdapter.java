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
import com.example.smartgk.model.Reviews;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.MyViewHolder> {

    List<Reviews> mList;
    Context context;

    public ReviewsAdapter(Context context, List<Reviews> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reviews, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Reviews reviews = mList.get(position);
        holder.reviewerImage.setImageResource(reviews.getReviewerImg());
        holder.reviewerName.setText(reviews.getReviewerName());
        holder.reviewDate.setText(reviews.getReviewDate());
        holder.reviewDesc.setText(reviews.getReviewDesc());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView reviewerImage;
        TextView reviewerName, reviewDate, reviewDesc;

        public MyViewHolder(View itemView) {
            super(itemView);

            reviewerImage = (ImageView) itemView.findViewById(R.id.review_image);
            reviewDate = itemView.findViewById(R.id.review_date);
            reviewerName = itemView.findViewById(R.id.review_person_name);
            reviewDesc = itemView.findViewById(R.id.review_desc);
        }


    }

}