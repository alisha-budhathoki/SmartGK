package com.example.smartgk.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.smartgk.Actvities.ExamFormActivity;
import com.example.smartgk.R;

public class ExamFragment extends Fragment {
   Button viewExam;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        viewExam = view.findViewById(R.id.viewExam);
        viewExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExamFormActivity.class);
                startActivity(intent);
            }
        });
        return  view;
    }
}
