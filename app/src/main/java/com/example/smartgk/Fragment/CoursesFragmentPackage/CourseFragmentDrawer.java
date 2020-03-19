package com.example.smartgk.Fragment.CoursesFragmentPackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.smartgk.Adapter.CFDAddapter;
import com.example.smartgk.R;
import com.example.smartgk.Retrofit.ApiClient;
import com.example.smartgk.Retrofit.ApiInterface;
import com.example.smartgk.model.CourseModelDrawer.Course;
import com.example.smartgk.model.CourseModelDrawer.CourseDrawerModel;
import com.example.smartgk.model.NewCourses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseFragmentDrawer extends Fragment {
    RecyclerView recyclerCoursesSearch;
    CFDAddapter cfdAddapter;
    SwipeRefreshLayout swipeRefreshLayout;
    Animation animation;
    ProgressBar progressBar;


    List<Course> courseArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses_drawer, container, false);
        recyclerCoursesSearch = view.findViewById(R.id.recyclerCourses);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);
        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        view.startAnimation(animation);
        progressBar = view.findViewById(R.id.courseProgress);

        //for swipe refresh layout
//        swipeRefreshLayout = view.findViewById(R.id.simpleSwipeCourseDrawer);
//        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.black));
//        swipeRefreshLayout.setOnRefreshListener(refreshListener);

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        retrofit2.Call<CourseDrawerModel> call = apiInterface.getCourses();
        call.enqueue(new Callback<CourseDrawerModel>() {
            @Override
            public void onResponse(Call<CourseDrawerModel> call, Response<CourseDrawerModel> response) {
                showCourses(getContext(), response.body().getResults().getCourse());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<CourseDrawerModel> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
        return view;
    }

    private List<Course> showCourses(Context context, List<Course> course) {
        courseArrayList.addAll(course);
        cfdAddapter = new CFDAddapter(getContext(), courseArrayList, CourseFragmentDrawer.this);
        recyclerCoursesSearch.setAdapter(cfdAddapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Vertical Orientation
        recyclerCoursesSearch.setLayoutManager(gridLayoutManager);
        return courseArrayList;
       //recyclerCoursesSearch.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }
}

//    private void showCourses1(Context context, ArrayList<CourseDrawerModel.Course> course) {
//        //arrayList.addAll(course);
//        cfdAddapter = new CFDAddapter(getContext(), arrayList, CourseFragmentDrawer.this);
//        recyclerCoursesSearch.setAdapter(cfdAddapter);
//        recyclerCoursesSearch.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//
//    }

//    private void showCourses3(Context context, List<CourseDrawerModel.Results.Course> course) {
//        arrayList.addAll(course);
//        cfdAddapter = new CFDAddapter(getContext(), arrayList, CourseFragmentDrawer.this);
//        recyclerCoursesSearch.setAdapter(cfdAddapter);
//        recyclerCoursesSearch.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//
//    }

//    private ArrayList<NewCourses> seeAllCourses() {
//        ArrayList<NewCourses> courseList = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            NewCourses newCourses = new NewCourses();
//            newCourses.setImageN(myCourseImageList[i]);
//            newCourses.setCourseNameN(myCourseTitle[i]);
//            newCourses.setCoursePriceN(myCoursePriceList[i]);
//
//            courseList.add(newCourses);
//        }
//        return courseList;
//    }

//    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
//
//        @Override
//        public void onRefresh() {
//            //Animation on refresh
//            Animation fadeIn = new AlphaAnimation(0, 1);
//            fadeIn.setDuration(1000);
//            AnimationSet animation = new AnimationSet(true);
//            animation.addAnimation(fadeIn);
//            getView().startAnimation(animation);
//
//            recyclerCoursesSearch = getView().findViewById(R.id.recyclerCourses);
//            cfdAddapter = new CFDAddapter(getContext(), arrayList, CourseFragmentDrawer.this);
//            recyclerCoursesSearch.setAdapter(cfdAddapter);
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
//            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Vertical Orientation
//            recyclerCoursesSearch.setLayoutManager(gridLayoutManager);
//            swipeRefreshLayout.setRefreshing(false);
//
//        }
//    };
//}
