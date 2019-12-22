package com.example.smartgk.Actvities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.smartgk.Adapter.SlidingMenuAdapter;
import com.example.smartgk.Fragment.ExamFragment;
import com.example.smartgk.Fragment.InvoiceFragment;
import com.example.smartgk.Fragment.LiveClassFragment;
import com.example.smartgk.Fragment.NotesFragment;
import com.example.smartgk.Fragment.NoticeFragment;
import com.example.smartgk.Fragment.VideosFragment;
import com.example.smartgk.Fragment.ViewCoursesFragment;
import com.example.smartgk.R;
import com.example.smartgk.model.ItemSlideMenu;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    Toolbar toolbar;
    private TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tabLayout = findViewById(R.id.tabsP);
        viewPager = findViewById(R.id.viewpagerP);

        ViewPage viewPage = new ViewPage(getSupportFragmentManager());
        viewPage.AddFragment(new ViewCoursesFragment(), "View Courses");
        viewPage.AddFragment(new InvoiceFragment(), "Invoice");
        viewPage.AddFragment(new ExamFragment(), "Exam");


        viewPager.setAdapter(viewPage);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.mintGreen), getResources().getColor(R.color.white));

    }
}

