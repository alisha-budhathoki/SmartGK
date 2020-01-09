package com.example.smartgk.Fragment.BookFragmentPackage;

import android.os.Bundle;
import android.os.Handler;
import android.print.PrinterId;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.smartgk.Adapter.BuyBooksAdapter2;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.model.BuyBooks;

import java.util.ArrayList;

public class BooksFragment extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<BuyBooks> mList3;
    BuyBooksAdapter2 buyBooksAdapter;
    SwipeRefreshLayout swipeRefreshLayout;

    private int[] myBookImageList = new int[]{R.drawable.pic_alchemist, R.drawable.pic_brave,R.drawable.pic_leanin, R.drawable.pic_brave,R.drawable.pic_alchemist,R.drawable.pic_alchemist,R.drawable.pic_alchemist,R.drawable.pic_alchemist};
    private String[] myBookPriceList = new String[]{"100","380" ,"1300","1500","540","540","540","540"};
    private String[] myBookTitle = new String[]{"Alchemist","Brave" ,"Lean in","Brave","Alchemist","Alchemist","Alchemist","Alchemist"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_books, container, false);
        recyclerView = view.findViewById(R.id.recyclerBook);

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


        recyclerView = view.findViewById(R.id.recyclerBook);
        mList3 = seeBooks();
        buyBooksAdapter = new BuyBooksAdapter2(getContext(), mList3, BooksFragment.this);
        recyclerView.setAdapter(buyBooksAdapter);
//        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView,setFo

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Vertical Orientation
        recyclerView.setLayoutManager(gridLayoutManager);
        // set LayoutManager to RecyclerView
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    private ArrayList<BuyBooks> seeBooks() {
        ArrayList<BuyBooks> booklist = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            BuyBooks buyBooks = new BuyBooks();
            buyBooks.setBookImg(myBookImageList[i]);
            buyBooks.setBookName(myBookTitle[i]);
            buyBooks.setBookPrice(myBookPriceList[i]);

            booklist.add(buyBooks);
        }
        return booklist;
    }

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {

            Animation fadeIn = new AlphaAnimation(0,1);
            fadeIn.setDuration(1000);
            AnimationSet animation = new AnimationSet(true);
            animation.addAnimation(fadeIn);
            getView().startAnimation(animation);

            mList3 = seeBooks();
            recyclerView = getView().findViewById(R.id.recyclerBook);
            buyBooksAdapter = new BuyBooksAdapter2(getContext(), mList3, BooksFragment.this);
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
