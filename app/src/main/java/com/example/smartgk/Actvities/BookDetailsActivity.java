package com.example.smartgk.Actvities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.smartgk.Fragment.AdditionalInfoFragment;
import com.example.smartgk.Fragment.ExamFragment;
import com.example.smartgk.Fragment.InformationFragment;
import com.example.smartgk.Fragment.LiveClassFragment;
import com.example.smartgk.Fragment.NotesFragment;
import com.example.smartgk.Fragment.NoticeFragment;
import com.example.smartgk.Fragment.ReviewsFragment;
import com.example.smartgk.Fragment.VideosFragment;
import com.example.smartgk.R;
import com.google.android.material.tabs.TabLayout;

public class BookDetailsActivity extends AppCompatActivity {

    private TabLayout tabLayoutBookDetails;
    public ViewPager viewPagerBookDetails;
    Button goForInquiry;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        tabLayoutBookDetails = findViewById(R.id.bookTabs);
        viewPagerBookDetails = findViewById(R.id.bookViewpager);
        goForInquiry = findViewById(R.id.goForInquiry);

        goForInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goIntent = new Intent(getApplicationContext(), InquiryActivity.class);
                startActivity(goIntent);
            }
        });

        ViewPage ViewPageBook = new ViewPage(getSupportFragmentManager());
        ViewPageBook.AddFragment(new InformationFragment(), "Information");
        ViewPageBook.AddFragment(new AdditionalInfoFragment(), "Additional Information");
        ViewPageBook.AddFragment(new ReviewsFragment(), "Reviews");

        viewPagerBookDetails.setAdapter(ViewPageBook);
        tabLayoutBookDetails.setupWithViewPager(viewPagerBookDetails);

        tabLayoutBookDetails.setTabTextColors(getResources().getColor(R.color.mintGreen), getResources().getColor(R.color.white));


    }
}
