package com.example.smartgk.Viewmodel;

import android.app.Application;
import android.app.ListActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.smartgk.Database.AppRepository;
import com.example.smartgk.Database.BookData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BookViewModel extends AndroidViewModel {

public LiveData<List<BookData>> bookEntities;
private AppRepository appRepository;

private Executor executor=  Executors.newSingleThreadExecutor();
public MutableLiveData<BookData> booksMutableLiveData = new MutableLiveData<>();


    public BookViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getOurInstance(application);
        bookEntities = appRepository.bookEntities;
    }

public void getBooks(){
appRepository.getBooks();
}
}
