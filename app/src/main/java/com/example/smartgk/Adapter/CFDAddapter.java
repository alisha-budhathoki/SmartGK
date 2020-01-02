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

import com.example.smartgk.Fragment.CourseDetailFragment;
import com.example.smartgk.R;
import com.example.smartgk.model.NewCourses;

import java.util.List;

public class CFDAddapter extends RecyclerView.Adapter<CFDAddapter.MyViewHolder>  {

    List<NewCourses> mList;
    Context context;

    public CFDAddapter(Context context, List<NewCourses> mList){
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public CFDAddapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_courses_drawer, parent, false);
        CFDAddapter.MyViewHolder vh = new CFDAddapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final CFDAddapter.MyViewHolder holder, final int position) {
        final NewCourses newCourses =mList.get(position);
        holder.courseImage.setImageResource(newCourses.getImageN());
        holder.courseTitle.setText(newCourses.getCourseNameN());
        holder.coursePrice.setText(newCourses.getCoursePriceN());
        holder.coursesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intoBookSetails = new Intent(v.getContext(), CourseDetailFragment.class);
                context.startActivity(intoBookSetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView courseImage;
        TextView coursePrice, courseTitle;
        CardView coursesCard;
        public MyViewHolder(View itemView) {
            super(itemView);
            coursesCard = itemView.findViewById(R.id.cardA3_coursefr);
            courseImage = (ImageView) itemView.findViewById(R.id.course_img_drawer);
            courseTitle = itemView.findViewById(R.id.title_name_drawer);
            coursePrice = itemView.findViewById(R.id.course_price_drawer);
        }
    }
}
