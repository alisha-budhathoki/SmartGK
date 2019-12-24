package com.example.smartgk.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Actvities.ViewCourseDetailActivity;
import com.example.smartgk.Adapter.BestCoursesAdapter;
import com.example.smartgk.Adapter.BuyBooksAdapter;
import com.example.smartgk.Adapter.NewCourseAdapter;
import com.example.smartgk.R;
import com.example.smartgk.model.BestCourses;
import com.example.smartgk.model.BuyBooks;
import com.example.smartgk.model.NewCourses;

import java.util.ArrayList;

public class HomeFragmentSearch extends Fragment {
    RelativeLayout relativeLayout1;
    CardView cardView1;
    private RecyclerView recyclerView1, recyclerView2;
    private ArrayList<BestCourses> mList;
    BestCoursesAdapter bestCoursesAdapter;
    private ArrayList<NewCourses> mList2;
    NewCourseAdapter newCourseAdapter;
    private ArrayList<BuyBooks> mList3;
    BuyBooksAdapter buyBooksAdapter;



    private int[] myImageList = new int[]{R.drawable.book1, R.drawable.book1,R.drawable.book1, R.drawable.book1,R.drawable.book1};
    private String[] myPriceNameList = new String[]{"100","380" ,"1300","1500","540"};
    private String[] myBookTitle = new String[]{"Lohitutu Resturant and fast food","Coffee pasal - During the day" ,"Cafe De Pattrick","Bota Momos","Nanglo Bar and Resturant"};



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_search, container, false);

        recyclerView1 = view.findViewById(R.id.recycler1);
        mList = seeBooks();
        bestCoursesAdapter = new BestCoursesAdapter(getContext(), mList);
        recyclerView1.setAdapter(bestCoursesAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //for new course

        recyclerView2 = view.findViewById(R.id.recycler2);
        mList2 = seeNewCourses();
        newCourseAdapter = new NewCourseAdapter(getContext(), mList2);
        recyclerView2.setAdapter(newCourseAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

return view;
    }


    private ArrayList<NewCourses> seeNewCourses() {
            ArrayList<NewCourses> list2 = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                NewCourses newCourses = new NewCourses();
                newCourses.setCoursePriceN(myPriceNameList[i]);
                newCourses.setImageN(myImageList[i]);
                newCourses.setCourseNameN(myBookTitle[i]);

                list2.add(newCourses);
            }
            return list2;
        }


    private ArrayList<BestCourses> seeBooks() {
        ArrayList<BestCourses> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            BestCourses bestCourses = new BestCourses();
            bestCourses.setCoursePrice(myPriceNameList[i]);
            bestCourses.setImage(myImageList[i]);
            bestCourses.setCourseName(myBookTitle[i]);

            list.add(bestCourses);
        }
        return list;
    }

}
