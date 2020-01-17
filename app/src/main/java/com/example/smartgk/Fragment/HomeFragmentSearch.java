package com.example.smartgk.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartgk.Adapter.BuyBooksAdapter;
import com.example.smartgk.Adapter.NewCourseAdapter;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.Retrofit.ApiClient;
import com.example.smartgk.Retrofit.ApiInterface;
import com.example.smartgk.model.Home_model_real.Book;
import com.example.smartgk.model.Home_model_real.Carousel;
import com.example.smartgk.model.Home_model_real.Course;
import com.example.smartgk.model.Home_model_real.HomeModel2;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentSearch extends Fragment {
    private RecyclerView recyclerViewBooksHome, recyclerViewCourseHome;
    NewCourseAdapter newCourseAdapter;
    CarouselView carouselView;
    ProgressBar progressBar;
    BuyBooksAdapter bookHomeAdapter;
    Context context;
    String url = "http://cosmicnepal.com/client/newsmartgk/smartgk/uploads/";


    List<Book> booksArrayList = new ArrayList<>();
    List<Course> courseArrayList = new ArrayList<>();
    List<String>sampleImages = new ArrayList<>() ;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_search, container, false);
        progressBar = view.findViewById(R.id.homeProgress);
        recyclerViewBooksHome = view.findViewById(R.id.recycler3);
        recyclerViewCourseHome = view.findViewById(R.id.recycler2);


        carouselView = (CarouselView) view.findViewById(R.id.carouselView);



        //bACKEND iNTEGRATION
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        retrofit2.Call<HomeModel2> call = apiInterface.getHomePage();
        call.enqueue(new Callback<HomeModel2>() {
            @Override
            public void onResponse(Call<HomeModel2> call, Response<HomeModel2> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
//
                        //carousel view implementation
                        for (Carousel carousel : response.body().getResults().getCarousel()){
                            sampleImages.add(carousel.getFile());
                        }


                        carouselView.setImageListener(imageListener);
                        carouselView.setViewListener(viewListener);
                        carouselView.setPageCount(sampleImages.size());
                        carouselView.setSlideInterval(4000);

                        carouselView.setImageClickListener(new ImageClickListener() {
                            @Override
                            public void onClick(int position) {
                                Toast.makeText(getActivity(), "Clicked item: "+ position, Toast.LENGTH_SHORT).show();
                            }
                        });

                        showCourses(getContext(), response.body().getResults().getCourse());

                        showBooksHome(getContext(),response.body().getResults().getBook());
                        return;
                    }
                }


                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<HomeModel2> call, Throwable t) {
                Toast.makeText(getContext(),"Please check your Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    private void showCourses(Context context, List<Course> course) {
        courseArrayList.addAll(course);
        newCourseAdapter = new NewCourseAdapter(getContext(), courseArrayList, HomeFragmentSearch.this);
        recyclerViewCourseHome.setAdapter(newCourseAdapter);
        recyclerViewCourseHome.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
    }


    private void showBooksHome(Context context, List<Book> book) {
    booksArrayList.addAll(book);
        bookHomeAdapter = new BuyBooksAdapter(getContext(), booksArrayList, HomeFragmentSearch.this);
        recyclerViewBooksHome.setAdapter(bookHomeAdapter);
        recyclerViewBooksHome.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
    }


    // To set simple images
    final ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            //Picasso.w(ge()).load(sampleNetworkImageURLs[position]).placeholder(sampleImages[0]).error(sampleImages[3]).fit().centerCrop().into(imageView);
            Picasso.get()
                    .load(url+sampleImages.get(position))
                    .placeholder(R.drawable.book1)
                    .error(R.drawable.book1)
                    .into(imageView);
        }

    };

    // To set custom views
    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.view_custom, null);

            TextView labelTextView = (TextView) customView.findViewById(R.id.labelTextView);
            ImageView fruitImageView = (ImageView) customView.findViewById(R.id.fruitImageView);

            Glide
                    .with((context) )
                    .load(sampleImages.get(position))
                    .centerCrop()
                    .into(fruitImageView);

            labelTextView.setVisibility(View.GONE);

            carouselView.setIndicatorGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP);

            return customView;
        }
    };

    View.OnClickListener pauseOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            carouselView.pauseCarousel();
            carouselView.reSetSlideInterval(0);
        }
    };






    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("Home");
    }

}
