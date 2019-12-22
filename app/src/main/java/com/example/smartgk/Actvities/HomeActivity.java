package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.smartgk.Fragment.ExamFragment;
import com.example.smartgk.Fragment.LiveClassFragment;
import com.example.smartgk.Fragment.NotesFragment;
import com.example.smartgk.Fragment.NoticeFragment;
import com.example.smartgk.Fragment.VideosFragment;
import com.example.smartgk.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        ViewPage ViewPage = new ViewPage(getSupportFragmentManager());
        ViewPage.AddFragment(new VideosFragment(), "VIDEOS");
        ViewPage.AddFragment(new NotesFragment(), "NOTES");
        ViewPage.AddFragment(new LiveClassFragment(), "LIVE CLASS");
        ViewPage.AddFragment(new ExamFragment(), "EXAM");
        ViewPage.AddFragment(new NoticeFragment(), "NOTICE");

        viewPager.setAdapter(ViewPage);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.mintGreen), getResources().getColor(R.color.white));


    }

//    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new VideosFragment(), "VIDEOS");
//        adapter.addFragment(new NotesFragment(), "NOTES");
//        adapter.addFragment(new LiveClassFragment(), "LIVE CLASS");
//        adapter.addFragment(new ExamFragment(), "EXAM");
//        adapter.addFragment(new NoticeFragment(), "NOTICE");
//        viewPager.setAdapter(adapter);
//    }
//    class ViewPagerAdapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();
//
//        public ViewPagerAdapter(FragmentManager manager) {
//            super(manager);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
//    }
}
