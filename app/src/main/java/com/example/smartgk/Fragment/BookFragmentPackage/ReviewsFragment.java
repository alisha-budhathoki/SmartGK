package com.example.smartgk.Fragment.BookFragmentPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Adapter.NoticeAdapter;
import com.example.smartgk.Adapter.ReviewsAdapter;
import com.example.smartgk.R;
import com.example.smartgk.model.Reviews;

import java.util.ArrayList;

public class ReviewsFragment extends Fragment {

    private int[] reviewerPics = new int[]{R.drawable.office_pic, R.drawable.office_pic,R.drawable.office_pic, R.drawable.office_pic,R.drawable.office_pic};
    private String[] reviewDate = new String[]{"2009-12-23","2009-12-23" ,"2009-12-23","2009-12-23","2009-12-23"};
    private String[] reviewerName = new String[]{"John Doe","John Doe" ,"John Doe","John Doe","John Doe"};
    private String[] reviewDesc = new String[]{"Alchemist","Brave" ,"Lean in","Brave","Alchemist"};

    ReviewsAdapter reviewsAdapter;
    RecyclerView recyclerViewReviews;
    ArrayList<Reviews> mListReviews;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        recyclerViewReviews = view.findViewById(R.id.recyclerReviews);
        mListReviews = seeReviews();
        reviewsAdapter = new ReviewsAdapter(getContext(), mListReviews);
        recyclerViewReviews.setAdapter(reviewsAdapter);

        recyclerViewReviews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        return view;
    }

    private ArrayList<Reviews> seeReviews() {
        ArrayList<Reviews> noticeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Reviews reviews = new Reviews();
            reviews.setReviewerImg(reviewerPics[i]);
            reviews.setReviewDate(reviewDate[i]);
            reviews.setReviewerName(reviewerName[i]);
            reviews.setReviewDesc(reviewDesc[i]);

            noticeList.add(reviews);
        }
        return noticeList;
    }
    }

