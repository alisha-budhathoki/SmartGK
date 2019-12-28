package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
                Intent goBack = new Intent(getApplicationContext(), BookDetailsActivity.class);
                startActivity(goBack);
            }
        });

    }
}
