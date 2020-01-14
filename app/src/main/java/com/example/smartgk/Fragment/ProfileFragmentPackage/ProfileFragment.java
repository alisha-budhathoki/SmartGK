package com.example.smartgk.Fragment.ProfileFragmentPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.smartgk.Actvities.ChangePasswordActivity;
import com.example.smartgk.Actvities.EditProfileActivity;
import com.example.smartgk.Fragment.CourseDetailFragmentTabs.ExamFragment;
import com.example.smartgk.Fragment.ProfileFragmentPackage.InvoiceFragment;
import com.example.smartgk.Fragment.ProfileFragmentPackage.ViewCoursesFragment;
import com.example.smartgk.Fragment.ViewPage;
import com.example.smartgk.Retrofit.ApiClient;
import com.example.smartgk.Retrofit.ApiInterface;
//import com.example.smartgk.model.UserModelClass;
import com.example.smartgk.model.user_model.UserModelClass;
import com.example.smartgk.utitlies.SharedPreferenceClass;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.smartgk.Retrofit.ApiClient.apiInterface;
import static  com.example.smartgk.Retrofit.ApiClient.makeApiInterface;

public class ProfileFragment extends Fragment {
    Toolbar toolbar;
    private TabLayout tabLayout;
    ViewPager viewPager;
    TextView profName, usernameProfle, phoneProfile, addressProfile, urlProfile, emailProfile, profileBio ;
    ImageView profImage;
    SharedPreferenceClass sharedPreferenceClass;
    Button changePassword, editProfile;
    ProgressBar progressBar;
    //ArrayList<UserModelClass.Results> arrayList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tabLayout = view.findViewById(R.id.tabsP);
        viewPager = view.findViewById(R.id.viewpagerP);
        profName = view.findViewById(R.id.proNm);
        profImage = view.findViewById(R.id.profImg);
        changePassword = view.findViewById(R.id.chngPw);
        editProfile = view.findViewById(R.id.edtProf);
        usernameProfle = view.findViewById(R.id.usernameProf);
        emailProfile = view.findViewById(R.id.emailAdderessProf);
        addressProfile = view.findViewById(R.id.locationProf);
        progressBar = view.findViewById(R.id.profileProgress);
        phoneProfile = view.findViewById(R.id.phoneNoProf);
        urlProfile = view.findViewById(R.id.urlProf);
        profileBio= view.findViewById(R.id.profDesc);


        sharedPreferenceClass = new SharedPreferenceClass(getContext());
        profName.setText(sharedPreferenceClass.getName());
        usernameProfle.setText(sharedPreferenceClass.getName());
        emailProfile.setText(sharedPreferenceClass.getEmail());
        String uid = sharedPreferenceClass.getUid();

        Glide
                .with(getContext())
                .load(sharedPreferenceClass.getPic())
                .centerCrop()
                .into(profImage);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEditProfile = new Intent(getContext(), EditProfileActivity.class);
                startActivity(toEditProfile);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toChangePw = new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(toChangePw);


            }
});



        ViewPage viewPage = new ViewPage(getChildFragmentManager());
        viewPage.AddFragment(new ViewCoursesFragment(), "View Courses");
        viewPage.AddFragment(new InvoiceFragment(), "Invoice");
        viewPage.AddFragment(new ExamFragment(), "Exam");


        viewPager.setAdapter(viewPage);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.mintGreen), getResources().getColor(R.color.white));


        //bACKEND iNTEGRATION
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        retrofit2.Call<UserModelClass> call = apiInterface.getUserProfile(uid);
        call.enqueue(new Callback<UserModelClass>() {
            @Override
            public void onResponse(Call<UserModelClass> call, Response<UserModelClass> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        profName.setText(response.body().getResults().getUser().getName());
                        addressProfile.setText(response.body().getResults().getUser().getAddress());
                        phoneProfile.setText(response.body().getResults().getUser().getPhone_no());
                        profileBio.setText(response.body().getResults().getUser().getBio());
                        response.body().getResults().getGetPaper().get(0).getPaper_name();
                    }
                }


                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<UserModelClass> call, Throwable t) {
                Toast.makeText(getContext(),"Please check your Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

//    private void showNews(Context context, ArrayList<UserModelClass.Results> results) {
//        arrayList.addAll(results);
//
//    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).toolbarName("Profile");
    }

    }
