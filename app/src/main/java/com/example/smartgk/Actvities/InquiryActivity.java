package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.smartgk.Fragment.BookDetailsFragment;
import com.example.smartgk.Fragment.ContactFragment;
import com.example.smartgk.Fragment.HomeFragmentSearch;
import com.example.smartgk.R;

public class InquiryActivity extends AppCompatActivity {
    TextView goBackToDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        goBackToDetail = findViewById(R.id.goBAckFromInquire);
        goBackToDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
