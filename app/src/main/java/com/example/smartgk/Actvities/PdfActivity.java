package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartgk.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {
    PDFView pdfView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfView1 = (PDFView) findViewById(R.id.pdf1);
        pdfView1.fromAsset("sample.pdf").defaultPage(1)
                .enableSwipe(true)
                .load();
    }
}