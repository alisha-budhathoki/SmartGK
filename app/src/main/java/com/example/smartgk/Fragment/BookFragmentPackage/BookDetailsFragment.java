package com.example.smartgk.Fragment.BookFragmentPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.smartgk.Actvities.InquiryActivity;
import com.example.smartgk.Fragment.ViewPage;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.utitlies.Constants;
import com.google.android.material.tabs.TabLayout;

public class BookDetailsFragment extends Fragment {
    private TabLayout tabLayoutBookDetails;
    public ViewPager viewPagerBookDetails;
    Button goForInquiry;
    TextView bookName1, bookName2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books_details, container, false);
        bookName1 = view.findViewById(R.id.bookNameTxt);

        tabLayoutBookDetails = view.findViewById(R.id.bookTabs);
        viewPagerBookDetails = view.findViewById(R.id.bookViewpager);
        goForInquiry = view.findViewById(R.id.goForInquiry);

         Bundle b = getArguments();
                if (b != null)
                {
                    String bookTitle2 = getArguments().getString(Constants.BOOK_TITLE2);
                    bookName1.setText(bookTitle2);

                    String bookTitle1 = getArguments().getString(Constants.BOOK_TITLE1);
                    bookName1.setText(bookTitle1);

        //
        //            Toast.makeText(getContext(), newsDesc,Toast.LENGTH_SHORT).show();
        //            System.out.println("*******strtext*********"+newsDesc);

                }

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
