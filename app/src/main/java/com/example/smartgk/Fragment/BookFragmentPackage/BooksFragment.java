package com.example.smartgk.Fragment.BookFragmentPackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.print.PrinterId;
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

import com.example.smartgk.Adapter.BuyBooksAdapter2;
import com.example.smartgk.Database.BookData;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.Retrofit.ApiClient;
import com.example.smartgk.Retrofit.ApiInterface;
import com.example.smartgk.Viewmodel.BookViewModel;
import com.example.smartgk.model.BooksModel;
import com.example.smartgk.model.BuyBooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.smartgk.Retrofit.ApiClient.apiInterface;
import static  com.example.smartgk.Retrofit.ApiClient.makeApiInterface;

public class BooksFragment extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<BooksModel.Results> mList3;
    BuyBooksAdapter2 buyBooksAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    BookViewModel bookViewModel;
    ProgressBar progressBar;
    ArrayList<BooksModel.Results> arrayList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_books, container, false);
        recyclerView = view.findViewById(R.id.recyclerBook);
        progressBar = view.findViewById(R.id.bookProgress);

        progressBar.setVisibility(View.VISIBLE);

        //Animation
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);
        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        view.startAnimation(animation);

        //swiperefreshlayout
        swipeRefreshLayout = view.findViewById(R.id.simpleSwipeRefresh);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.black));
        swipeRefreshLayout.setOnRefreshListener(refreshListener);

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<BooksModel> call = apiInterface.getBooks();
        call.enqueue(new Callback<BooksModel>() {
            @Override
            public void onResponse(Call<BooksModel> call, Response<BooksModel> response) {
                showBooks(getContext(), (ArrayList<BooksModel.Results>) response.body().results);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<BooksModel> call, Throwable t) {
            Toast.makeText(getContext(),"Something went wrong", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            }
        });
        return view;
    }

    private List<BooksModel.Results> showBooks(Context context, ArrayList<BooksModel.Results> results) {

        arrayList.addAll(results);
        buyBooksAdapter = new BuyBooksAdapter2(getContext(), arrayList, BooksFragment.this);
        recyclerView.setAdapter(buyBooksAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Vertical Orientation
        recyclerView.setLayoutManager(gridLayoutManager);
        return arrayList;
    }



    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {

            Animation fadeIn = new AlphaAnimation(0,1);
            fadeIn.setDuration(1000);
            AnimationSet animation = new AnimationSet(true);
            animation.addAnimation(fadeIn);
            getView().startAnimation(animation);


            recyclerView = getView().findViewById(R.id.recyclerBook);
            buyBooksAdapter = new BuyBooksAdapter2(getContext(), arrayList, BooksFragment.this);
            recyclerView.setAdapter(buyBooksAdapter);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Vertical Orientation
            recyclerView.setLayoutManager(gridLayoutManager);
            swipeRefreshLayout.setRefreshing(false);

        }

    };



    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("Books");
    }

}
