package com.example.smartgk.Fragment.NewsFragmentPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartgk.MainActivity;
import com.example.smartgk.R;

public class NewsDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemrnt_news_detail, container, false);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("News Detail");
    }
}
