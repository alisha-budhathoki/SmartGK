package com.example.smartgk.Fragment.NewsFragmentPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.utitlies.Constants;

public class NewsDetailFragment extends Fragment {
    private TextView titleNews, titleDesc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemrnt_news_detail, container, false);
        titleNews = view.findViewById(R.id.newsTitleHere);
        titleDesc = view.findViewById(R.id.desc_news_detail);

        Bundle b = getArguments();
        if (b != null)
        {
            String newsTitle = getArguments().getString(Constants.NEWS_TITLE);
            String newsDesc = getArguments().getString(Constants.NEWS_DESCRIPTION);

            titleNews.setText(newsTitle);
            titleDesc.setText(newsDesc);
//
//            Toast.makeText(getContext(), newsDesc,Toast.LENGTH_SHORT).show();
//            System.out.println("*******strtext*********"+newsDesc);

        }

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("News Detail");

    }
}
