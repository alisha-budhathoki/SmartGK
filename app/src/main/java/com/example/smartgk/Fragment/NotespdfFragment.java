package com.example.smartgk.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.smartgk.Actvities.PdfActivity;
import com.example.smartgk.R;

import java.io.File;
import java.io.IOException;

import flipagram.assetcopylib.AssetCopier;

public class NotespdfFragment extends Fragment {
    CardView cardPdf;
    ImageView pdfNoteImg, downlaod;
    TextView pdfNoteName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notes_pdf, container, false);
        cardPdf = view.findViewById(R.id.cardPdfFragment);
        pdfNoteImg = view.findViewById(R.id.pdfNoteImg);
        pdfNoteName = view.findViewById(R.id.pdf_name);
        downlaod = view.findViewById(R.id.downlaodIcon);

        pdfNoteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotToPdf = new Intent(getContext(), PdfActivity.class);
                startActivity(gotToPdf);
            }
        });

        pdfNoteName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotToPdf = new Intent(getContext(), PdfActivity.class);
                startActivity(gotToPdf);
            }
        });

        //for downlaoding notes

        if (ContextCompat.checkSelfPermission(
                getContext(),
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    0);
        }

        downlaod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = -1;
                try {
                    // This will fail if the user didn't allow the permissions
                    File destDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    destDir.mkdirs();
                    count = new AssetCopier(getContext())
                            .withFileScanning()
                            .copy("sample.pdf", destDir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(
                        getContext(),
                        (count == -1 ? "There was an error copying" : "This Pdf is saved in you device. " + count),
                        Toast.LENGTH_LONG
                ).show();
            }
        });


        return view;
    }
}
