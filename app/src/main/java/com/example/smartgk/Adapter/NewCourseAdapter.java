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

import com.bumptech.glide.Glide;
import com.example.smartgk.Fragment.CoursesFragmentPackage.CourseDetailFragment;
import com.example.smartgk.Fragment.HomeFragmentSearch;
import com.example.smartgk.R;
import com.example.smartgk.model.Home_model_real.Course;
import com.example.smartgk.model.NewCourses;
import com.example.smartgk.utitlies.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewCourseAdapter extends RecyclerView.Adapter<NewCourseAdapter.MyViewHolder> {

    List<Course> mList;
    Context context;
    HomeFragmentSearch homeFragment;

    public NewCourseAdapter(Context context, List<Course> mList, HomeFragmentSearch homeFragmentSearch) {
        this.context = context;
        this.mList = mList;
        this.homeFragment = homeFragmentSearch;
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
        final Course newCourses = mList.get(position);
        //holder.bookTitle.setText(newCourses.get());
        holder.courseTitle.setText(newCourses.getLevel_name());
        holder.coursePrice.setText(newCourses.getPackage_price());
        Glide
                .with((context) )
                .load(Constants.url+newCourses)
                .centerCrop()
                .error(R.drawable.book2)
                .into(holder.image);
//        Picasso.get()
//                .load(Constants.url+newCourses)
//                .placeholder(R.drawable.book1)
//                .error(R.drawable.book1)
//                .into(holder.image);
        System.out.println("sjhsjksjs"+holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CourseDetailFragment();
                Bundle args = new Bundle();
                FragmentTransaction transaction = homeFragment.getActivity().getSupportFragmentManager().beginTransaction();
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
        ImageView image;
        TextView courseTitle, coursePrice;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.newCourse_img);
            courseTitle = itemView.findViewById(R.id.newCourse_title);
            coursePrice = itemView.findViewById(R.id.newCourse_price);
            cardView = itemView.findViewById(R.id.cardNewCourse);
        }
    }
}
