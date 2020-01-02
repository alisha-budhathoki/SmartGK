package com.example.smartgk.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Adapter.ExamAdapter;
import com.example.smartgk.R;
import com.example.smartgk.model.Exams;

import java.util.ArrayList;

public class ExamFragment extends Fragment {

    private String[] myExamDate = new String[]{"0000-00-00","0000-00-00" ,"0000-00-00","0000-00-00","0000-00-00"};
    private String[] myExamStartingTime = new String[]{"5:A.M.","5:A.M.","5:A.M.","5:A.M.","5:A.M."};
    private String[] myExamEndingTime = new String[]{"5:A.M.","5:A.M.","5:A.M.","5:A.M.","5:A.M."};
    private String[] myExamName = new String[]{"Nepal Rastra Bank - Level 4","Nepal Rastra Bank - Level 4","Nepal Rastra Bank - Level 4", "Nepal Rastra Bank - Level 4", "Nepal Rastra Bank - Level 4"};

    ExamAdapter examAdapter;
    Button viewExam;
    ArrayList<Exams> mListExams;

    RecyclerView examRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        examRecyclerView = view.findViewById(R.id.recyclerExam);

        mListExams = seeExams();
        examAdapter = new ExamAdapter(getContext(), mListExams, ExamFragment.this);
        examRecyclerView.setAdapter(examAdapter);
        examRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return  view;
    }

    private ArrayList<Exams> seeExams() {
            ArrayList<Exams> listExams = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Exams exams = new Exams();
                exams.setCurrentDate(myExamDate[i]);
                exams.setEndDate(myExamEndingTime[i]);
                exams.setStartDate(myExamStartingTime[i]);
                exams.setExamTitle(myExamName[i]);

                listExams.add(exams);
            }
            return listExams;
    }
}
