package com.example.smartgk.Fragment.CoursesFragmentPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.smartgk.Adapter.BuyBooksAdapter2;
import com.example.smartgk.Adapter.CFDAddapter;
import com.example.smartgk.R;
import com.example.smartgk.model.BuyBooks;
import com.example.smartgk.model.NewCourses;

import java.util.ArrayList;

public class CourseFragmentDrawer extends Fragment {
    RecyclerView recyclerCoursesSearch;
    private ArrayList<NewCourses> mListCourses;
    CFDAddapter cfdAddapter;
    SwipeRefreshLayout swipeRefreshLayout;
    Animation animation;

    private int[] myCourseImageList = new int[]{R.drawable.book1, R.drawable.book1, R.drawable.book1, R.drawable.book1, R.drawable.book1,R.drawable.book1, R.drawable.book1};
    private String[] myCoursePriceList = new String[]{"100", "380", "1300", "1500", "540","1500", "540"};
    private String[] myCourseTitle = new String[]{"Lohitutu Resturant and fast food", "Coffee pasal - During the day", "Cafe De Pattrick", "Bota Momos", "Nanglo Bar and Resturant", "Bota Momos", "Nanglo Bar and Resturant"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses_drawer, container, false);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);
        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        view.startAnimation(animation);

        //for swipe refresh layout
        swipeRefreshLayout = view.findViewById(R.id.simpleSwipeCourseDrawer);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.black));
        swipeRefreshLayout.setOnRefreshListener(refreshListener);

        recyclerCoursesSearch = view.findViewById(R.id.recyclerCourses);
        mListCourses = seeAllCourses();
        cfdAddapter = new CFDAddapter(getContext(), mListCourses, CourseFragmentDrawer.this);
        recyclerCoursesSearch.setAdapter(cfdAddapter);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Vertical Orientation
        recyclerCoursesSearch.setLayoutManager(gridLayoutManager);
        return view;
    }

    private ArrayList<NewCourses> seeAllCourses() {
        ArrayList<NewCourses> courseList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            NewCourses newCourses = new NewCourses();
            newCourses.setImageN(myCourseImageList[i]);
            newCourses.setCourseNameN(myCourseTitle[i]);
            newCourses.setCoursePriceN(myCoursePriceList[i]);

            courseList.add(newCourses);
        }
        return courseList;
    }

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            //Animation on refresh
            Animation fadeIn = new AlphaAnimation(0, 1);
            fadeIn.setDuration(1000);
            AnimationSet animation = new AnimationSet(true);
            animation.addAnimation(fadeIn);
            getView().startAnimation(animation);

            recyclerCoursesSearch = getView().findViewById(R.id.recyclerCourses);
            mListCourses = seeAllCourses();
            cfdAddapter = new CFDAddapter(getContext(), mListCourses, CourseFragmentDrawer.this);
            recyclerCoursesSearch.setAdapter(cfdAddapter);


            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Vertical Orientation
            recyclerCoursesSearch.setLayoutManager(gridLayoutManager);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
}
