package com.example.smartgk.Database;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.smartgk.Services.GetBooksService;
import com.example.smartgk.Services.LoginIntentService;
import com.example.smartgk.Services.RegisterService;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static  AppRepository ourInstance;
    public LiveData<List<BookData>> bookEntities;
    Context context;
    private Executor executor = Executors.newSingleThreadExecutor();

    private SmartGkDatabase mDb;

    public AppRepository(Context context) {
        mDb= SmartGkDatabase.getInstance(context);
        this.context = context;
//        bookEntities = getAllBookEntities();

    }

//    private LiveData<List<BookData>> getAllBookEntities() {
//        return mDb.getBooksDao().getAllBooks();
//    }

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

    public void registerUsers(String email, String password) {
        RegisterService.startRegistration(context, email, password);
    }

    public void getBooks() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
context.startService(new Intent(context, GetBooksService.class));
            }
        });
    }

//    public void deleteAllBooks() {
//
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                mDb.getBooksDao().nukeTable();
//            }
//        });
//    }
//
//    public void addAllStatements(final BookData[] bookData) {
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("statments size", ""+bookData.length);
//                mDb.getBooksDao().insertAll(bookData);
//            }
//        });
//    }
}
