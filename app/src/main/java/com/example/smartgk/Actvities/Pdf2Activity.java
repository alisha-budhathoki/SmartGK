package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartgk.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Pdf2Activity extends AppCompatActivity {
    PDFView pdfView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        pdfView2 = (PDFView) findViewById(R.id.pdf2);
        pdfView2.fromAsset("rts.pdf").load();
    }
}
