package com.example.smartgk.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Adapter.NewsAdapter;
import com.example.smartgk.Adapter.SucessStoriesAdapter;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.model.News;
import com.example.smartgk.model.SucessStories;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    private int[] myNewsPics = new int[]{R.drawable.office_pic, R.drawable.office_pic,R.drawable.office_pic, R.drawable.office_pic,R.drawable.office_pic};
    private String[] myNewsDate = new String[]{"0000-00-00","0000-00-00" ,"0000-00-00","0000-00-00","0000-00-00"};
    private String[] myNewsDesc = new String[]{"In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space.","In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space." ,"In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space.","In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space.","In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline) followed by an initial at the beginning of the next paragraph. An initial is an oversized capital letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the original Old English manuscript of Beowulf. Outdenting is still used in English typography, though not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first line. This style can be seen in the (handwritten) United States Constitution from 1787. For additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph whitespace, or put in the indentation space."};

    NewsAdapter newsAdapter;
    RecyclerView recyclerViewNews;
    ArrayList<News> mListNews;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerViewNews = view.findViewById(R.id.recyclerNews);
        mListNews = seeNews();
        newsAdapter = new NewsAdapter(getContext(), mListNews, NewsFragment.this);
        recyclerViewNews.setAdapter(newsAdapter);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));



        return view;
    }

    private ArrayList<News> seeNews() {
        ArrayList<News> listNews = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            News news = new News();
            news.setNewsDate(myNewsDate[i]);
            news.setNewsImg(myNewsPics[i]);
            news.setNewsDesc(myNewsDesc[i]);

            listNews.add(news);
        }
        return listNews;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("News");
    }
}
