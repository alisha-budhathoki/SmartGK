package com.example.smartgk.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.smartgk.Adapter.NewCourseAdapter;
import com.example.smartgk.Adapter.SucessStoriesAdapter;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.model.BestCourses;
import com.example.smartgk.model.NewCourses;
import com.example.smartgk.model.SucessStories;

import java.util.ArrayList;

public class SucessStoryFragment extends Fragment {

    private int[] mySucessPics = new int[]{R.drawable.office_pic, R.drawable.office_pic,R.drawable.office_pic, R.drawable.office_pic,R.drawable.office_pic};
    private String[] mySucessTitle = new String[]{"John Doe","John Doe" ,"John Doe","John Doe","John Doe"};
    private String[] mySucessDesc = new String[]{"In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space.","In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space." ,"In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space.","In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space.","In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space."};

    SucessStoriesAdapter sucessStoriesAdapter;
    RecyclerView recyclerViewSucess;
    ArrayList<SucessStories> mListSucess;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sucess_stories, container, false);

        //Animation
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);
        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        view.startAnimation(animation);

        //swiperefreshlayout
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshNews);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.black));
        swipeRefreshLayout.setOnRefreshListener(refreshListener);


        recyclerViewSucess = view.findViewById(R.id.recyclerSucess);
        mListSucess = seeNewSucessStories();
        sucessStoriesAdapter = new SucessStoriesAdapter(getContext(), mListSucess);
        recyclerViewSucess.setAdapter(sucessStoriesAdapter);
        recyclerViewSucess.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        return view;
    }

    private ArrayList<SucessStories> seeNewSucessStories() {
        ArrayList<SucessStories> listSucess = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SucessStories sucessStories = new SucessStories();
            sucessStories.setSucessName(mySucessTitle[i]);
            sucessStories.setSucessImg(mySucessPics[i]);
            sucessStories.setSucessDesc(mySucessDesc[i]);

            listSucess.add(sucessStories);
        }
        return listSucess;
    }

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {

            Animation fadeIn = new AlphaAnimation(0,1);
            fadeIn.setDuration(1000);
            AnimationSet animation = new AnimationSet(true);
            animation.addAnimation(fadeIn);
            getView().startAnimation(animation);

            recyclerViewSucess = getView().findViewById(R.id.recyclerSucess);
            mListSucess = seeNewSucessStories();
            sucessStoriesAdapter = new SucessStoriesAdapter(getContext(), mListSucess);
            recyclerViewSucess.setAdapter(sucessStoriesAdapter);
            recyclerViewSucess.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

            swipeRefreshLayout.setRefreshing(false);

        }
    };

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("Sucess Stories");
    }
}
