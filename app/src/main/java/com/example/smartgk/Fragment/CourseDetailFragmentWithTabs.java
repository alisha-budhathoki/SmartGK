package com.example.smartgk.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.smartgk.Actvities.ViewPage;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.google.android.material.tabs.TabLayout;

public class CourseDetailFragmentWithTabs extends Fragment {
    private TabLayout tabLayout;
    public ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_detail_tabs, container, false);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);
        ViewPage ViewPage = new ViewPage(getFragmentManager());
        ViewPage.AddFragment(new VideosFragment(), "Videos");
        ViewPage.AddFragment(new NotespdfFragment(), "Notes");
        ViewPage.AddFragment(new LiveClassFragment(), "Live Class");
        ViewPage.AddFragment(new ExamFragment(), "Exam");
        ViewPage.AddFragment(new NoticeFragment(), "Notice");

        viewPager.setAdapter(ViewPage);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.mintGreen), getResources().getColor(R.color.white));


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("Courses");
    }
}

