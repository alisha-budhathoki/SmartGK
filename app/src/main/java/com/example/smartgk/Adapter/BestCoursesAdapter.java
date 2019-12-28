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
import com.example.smartgk.Fragment.CourseFragment;
import com.example.smartgk.R;
import com.example.smartgk.model.BestCourses;

import java.util.List;

public class BestCoursesAdapter extends RecyclerView.Adapter<BestCoursesAdapter.MyViewHolder> {

    List<BestCourses> mList;
    Context context;

    public BestCoursesAdapter(Context context, List<BestCourses> mList){
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_best_courses, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final BestCourses bestCourses =mList.get(position);
        holder.image.setImageResource(bestCourses.getImage());
        holder.bookTitle.setText(bestCourses.getCourseName());
        holder.bookPrice.setText(bestCourses.getCoursePrice());
        holder.cardViewBst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CourseActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView image;
        TextView bookPrice, bookTitle;
        CardView cardViewBst;
        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.course_img);
            bookTitle = itemView.findViewById(R.id.title_name);
            bookPrice = itemView.findViewById(R.id.course_price);
            cardViewBst = itemView.findViewById(R.id.cardA1);
        }


    }

}
