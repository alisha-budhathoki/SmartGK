package com.example.smartgk.Database;

import android.content.Context;

import com.example.smartgk.Services.LoginIntentService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static  AppRepository ourInstance;
    Context context;
    private Executor executor = Executors.newSingleThreadExecutor();

    private SmartGkDatabase mDb;

    public AppRepository(Context context) {
        mDb= SmartGkDatabase.getInstance(context);
        this.context = context;

    }

    public static AppRepository getOurInstance(Context context){

        if(ourInstance==null)
            ourInstance = new AppRepository(context);

        return ourInstance;
    }

    public void loginVendor(String email, String password) {
        LoginIntentService.startActionLogin(context,email,password);

    }

    public void saveVendorDetails(final UserDetails userDetails) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.userDetailDao().insertVendorDetails(userDetails);
            }
        });
    }
}
