package com.example.smartgk.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartgk.Actvities.Pdf2Activity;
import com.example.smartgk.Actvities.PdfActivity;
import com.example.smartgk.R;

public class CourseDetailFragment extends AppCompatActivity {
    Button pdf1, pdf2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.fragment_course_details);
        super.onCreate(savedInstanceState);

        pdf1 = findViewById(R.id.btn1);
        pdf2 = findViewById(R.id.btn2);

        pdf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetailFragment.this, PdfActivity.class);
                startActivity(intent);
            }
        });
        pdf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetailFragment.this, Pdf2Activity.class);
                startActivity(intent);
            }
        });

    }
}
