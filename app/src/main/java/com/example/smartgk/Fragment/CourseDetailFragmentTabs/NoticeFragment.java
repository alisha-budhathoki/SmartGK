package com.example.smartgk.Fragment.CourseDetailFragmentTabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Adapter.NoticeAdapter;
import com.example.smartgk.R;
import com.example.smartgk.model.Notices;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {
    RecyclerView recyclerViewNotice;
    private ArrayList<Notices> mList;
    NoticeAdapter noticeAdapter;

    private String[] noticesDate = new String[]{"2009-12-23","2009-12-23" ,"2009-12-23","2009-12-23","2009-12-23"};
    private String[] noticesTitle = new String[]{"New Exams Starting soon","Results published of the first exams" ,"Find your career here","Find your career here","Find your career here"};
    private String[] noticesDesc = new String[]{"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam","Brave" ,"Lean in","Brave","Alchemist"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        recyclerViewNotice = view.findViewById(R.id.recyclerNotice);
        mList = seeNotices();
        noticeAdapter = new NoticeAdapter(getContext(), mList);
        recyclerViewNotice.setAdapter(noticeAdapter);

        recyclerViewNotice.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    private ArrayList<Notices> seeNotices() {
        ArrayList<Notices> noticeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Notices notices = new Notices();
            notices.setNoticeDate(noticesDate[i]);
            notices.setNoticeTitle(noticesTitle[i]);
            notices.setNoticeDesc(noticesDesc[i]);

            noticeList.add(notices);
        }
        return noticeList;
    }
    }

