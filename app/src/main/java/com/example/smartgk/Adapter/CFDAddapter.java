package com.example.smartgk.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartgk.Fragment.CoursesFragmentPackage.CourseDetailFragment;
import com.example.smartgk.Fragment.CoursesFragmentPackage.CourseFragmentDrawer;
import com.example.smartgk.R;
import com.example.smartgk.model.CourseModelDrawer.Course;
import com.example.smartgk.model.CourseModelDrawer.Course;
import com.example.smartgk.utitlies.Constants;


import java.util.List;

public class CFDAddapter extends RecyclerView.Adapter<CFDAddapter.MyViewHolder>  {

    List<Course> mList;
    Context context;
    CourseFragmentDrawer courseFragmentDrawer;

    public CFDAddapter(Context context, List<Course> mList, CourseFragmentDrawer courseDetailFragment){
        this.context = context;
        this.mList = mList;
        this.courseFragmentDrawer = courseDetailFragment;
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
        final Course course =mList.get(position);
        holder.courseTitle.setText(course.getDescription());
        holder.coursePrice.setText(course.getPackage_price());
        holder.coursePrice.setText(course.getPackage_price());
        Glide
                .with((context) )
                .load(Constants.url+course)
                .centerCrop()
                .error(R.drawable.course2)
                .into(holder.courseImage);

        holder.coursesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CourseDetailFragment();
                Bundle args = new Bundle();
                FragmentTransaction transaction = courseFragmentDrawer.getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content, fragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.addToBackStack(null);
                transaction.commit();
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
