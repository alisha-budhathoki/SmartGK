package com.example.smartgk.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.smartgk.Database.AppRepository;

public class RegisterViewmodel extends AndroidViewModel {

private AppRepository appRepository;

    public RegisterViewmodel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getOurInstance(application);
    }

    public void registerUsers(String email, String password){
        appRepository.registerUsers(email, password);
    }
}
