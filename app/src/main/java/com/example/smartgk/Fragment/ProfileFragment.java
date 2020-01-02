package com.example.smartgk.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.smartgk.Actvities.ChangePasswordActivity;
import com.example.smartgk.Actvities.EditProfileActivity;
import com.example.smartgk.Actvities.SharedPreferenceClass;
import com.example.smartgk.Actvities.ViewPage;
import com.example.smartgk.R;
import com.google.android.material.tabs.TabLayout;

public class ProfileFragment extends Fragment {
    Toolbar toolbar;
    private TabLayout tabLayout;
    ViewPager viewPager;
    TextView profName;
    ImageView profImage;
    SharedPreferenceClass sharedPreferenceClass;
    Button changePassword, editProfile;

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

        sharedPreferenceClass = new SharedPreferenceClass(getContext());
        profName.setText(sharedPreferenceClass.getName());

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

        return view;
    }
}
