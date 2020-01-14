package com.example.smartgk.Fragment.NewsFragmentPackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.smartgk.Adapter.NewsAdapter;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.Retrofit.ApiClient;
import com.example.smartgk.Retrofit.ApiInterface;
import com.example.smartgk.model.BooksModel;
import com.example.smartgk.model.News;
import com.example.smartgk.model.NewsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.smartgk.Retrofit.ApiClient.apiInterface;
import static  com.example.smartgk.Retrofit.ApiClient.makeApiInterface;


public class NewsFragment extends Fragment {

    NewsAdapter newsAdapter;
    RecyclerView recyclerViewNews;
    ArrayList<NewsModel.Results> arrayList = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressBar progressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
         recyclerViewNews = view.findViewById(R.id.recyclerNews);
            progressBar = view.findViewById(R.id.newsProgress);
            progressBar.setVisibility(View.VISIBLE);
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

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<NewsModel> call = apiInterface.getNews();
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                showNews(getContext(), (ArrayList<NewsModel.Results>) response.body().results);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(getContext(),"Please check your Internet COnnection", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void showNews(Context context, ArrayList<NewsModel.Results> results) {
        arrayList.addAll(results);
        newsAdapter = new NewsAdapter(getContext(), arrayList, NewsFragment.this);
        recyclerViewNews.setAdapter(newsAdapter);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }








    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {

            Animation fadeIn = new AlphaAnimation(0,1);
            fadeIn.setDuration(1000);
            AnimationSet animation = new AnimationSet(true);
            animation.addAnimation(fadeIn);
            getView().startAnimation(animation);

            recyclerViewNews = getView().findViewById(R.id.recyclerNews);
            newsAdapter = new NewsAdapter(getContext(), arrayList, NewsFragment.this);
            recyclerViewNews.setAdapter(newsAdapter);
            recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            swipeRefreshLayout.setRefreshing(false);

        }
    };

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("News");
    }
}
