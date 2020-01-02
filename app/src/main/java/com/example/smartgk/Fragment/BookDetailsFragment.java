package com.example.smartgk.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.smartgk.Actvities.InquiryActivity;
import com.example.smartgk.Actvities.ViewPage;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.google.android.material.tabs.TabLayout;

public class BookDetailsFragment extends Fragment {
    private TabLayout tabLayoutBookDetails;
    public ViewPager viewPagerBookDetails;
    Button goForInquiry;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books_details, container, false);
        tabLayoutBookDetails = view.findViewById(R.id.bookTabs);
        viewPagerBookDetails = view.findViewById(R.id.bookViewpager);
        goForInquiry = view.findViewById(R.id.goForInquiry);

        goForInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goIntent = new Intent(getContext(), InquiryActivity.class);
                startActivity(goIntent);
            }
        });

        ViewPage ViewPageBook = new ViewPage(getChildFragmentManager());
        ViewPageBook.AddFragment(new InformationFragment(), "Information");
        ViewPageBook.AddFragment(new AdditionalInfoFragment(), "Additional Information");
        ViewPageBook.AddFragment(new ReviewsFragment(), "Reviews");

        viewPagerBookDetails.setAdapter(ViewPageBook);
        tabLayoutBookDetails.setupWithViewPager(viewPagerBookDetails);

        tabLayoutBookDetails.setTabTextColors(getResources().getColor(R.color.mintGreen), getResources().getColor(R.color.white));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("Book Detail");
    }
}
