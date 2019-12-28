package com.example.smartgk.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.smartgk.Actvities.SharedPreferenceClass;
import com.example.smartgk.Actvities.ViewPage;
import com.example.smartgk.R;
import com.google.android.material.tabs.TabLayout;

public class ProfileFragment extends Fragment {
    Toolbar toolbar;
    private TabLayout tabLayout;
    ViewPager viewPager;
    TextView profName;
    ImageView profImage;
    SharedPreferenceClass sharedPreferenceClass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tabLayout = view.findViewById(R.id.tabsP);
        viewPager = view.findViewById(R.id.viewpagerP);
        profName = view.findViewById(R.id.proNm);
        profImage = view.findViewById(R.id.profImg);

        sharedPreferenceClass = new SharedPreferenceClass(getContext());
        profName.setText(sharedPreferenceClass.getName());

        Glide
                .with(getContext())
                .load(sharedPreferenceClass.getPic())
                .centerCrop()
                .into(profImage);

        ViewPage viewPage = new ViewPage(getChildFragmentManager());
        viewPage.AddFragment(new ViewCoursesFragment(), "View Courses");
        viewPage.AddFragment(new InvoiceFragment(), "Invoice");
        viewPage.AddFragment(new ExamFragment(), "Exam");


        viewPager.setAdapter(viewPage);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.mintGreen), getResources().getColor(R.color.white));

        return view;
    }
}
