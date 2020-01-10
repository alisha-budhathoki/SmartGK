package com.example.smartgk.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.smartgk.Database.AppRepository;
import com.example.smartgk.Database.UserDetails;

public class LoginActivityViewModel extends AndroidViewModel {
    private AppRepository mAppRepository;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        mAppRepository = AppRepository.getOurInstance(application);

    }

    public void loginUser(String email, String password) {
        mAppRepository.loginVendor(email,password);

    }

    public void saveVendorDetails(UserDetails userDetails){
        mAppRepository.saveVendorDetails(userDetails);
    }
}
