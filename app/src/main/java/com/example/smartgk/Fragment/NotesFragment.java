package com.example.smartgk.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.smartgk.Actvities.Pdf2Activity;
import com.example.smartgk.Actvities.PdfActivity;
import com.example.smartgk.R;

public class NotesFragment extends Fragment {
    CardView cardView1, cardView2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        cardView1 = view.findViewById(R.id.cardN1);
        cardView2 = view.findViewById(R.id.cardN2);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Pdf2Activity.class);
                startActivity(intent);
            }
        });

        return view;

    }
}
