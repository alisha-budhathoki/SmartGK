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
import com.example.smartgk.model.BestCourses;
import com.example.smartgk.model.NewCourses;

import java.util.List;

public class NewCourseAdapter extends RecyclerView.Adapter<NewCourseAdapter.MyViewHolder> {

    List<NewCourses> mList;
    Context context;

    public NewCourseAdapter(Context context, List<NewCourses> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_couses, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final NewCourses newCourses = mList.get(position);
        holder.image.setImageResource(newCourses.getImageN());
        holder.bookTitle.setText(newCourses.getCourseNameN());
        holder.bookPrice.setText(newCourses.getCoursePriceN());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView image;
        TextView bookPrice, bookTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.newCourse_img);
            bookTitle = itemView.findViewById(R.id.newCourse_title);
            bookPrice = itemView.findViewById(R.id.newCourse_price);
        }
    }
}
