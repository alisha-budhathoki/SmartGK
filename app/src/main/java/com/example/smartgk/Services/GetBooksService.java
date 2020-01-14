package com.example.smartgk.Services;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Shader;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;

import com.example.smartgk.Database.AppRepository;
import com.example.smartgk.Database.BookData;
import com.example.smartgk.model.BooksModel;
import com.example.smartgk.model.BuyBooks;
import com.example.smartgk.utitlies.JsonUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.smartgk.Retrofit.ApiClient.apiInterface;
import static  com.example.smartgk.Retrofit.ApiClient.makeApiInterface;


public class GetBooksService extends IntentService {
    AppRepository appRepository;
    SharedPreferences sharedPreferences;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public GetBooksService( ) {
        super("GetBooksService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        appRepository = AppRepository.getOurInstance(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (apiInterface == null)
            makeApiInterface();

Call<BooksModel> call = apiInterface.getBooks();
        call.enqueue(new Callback<BooksModel>() {
            @Override
            public void onResponse(Call<BooksModel> call, Response<BooksModel> response) {
            try{
                BookData[] bookData = JsonUtils.getBookObjectsFromJson(response.body().results);
//                appRepository.deleteAllBooks();
//                appRepository.addAllStatements(bookData);
            } catch (Exception e) {
                e.printStackTrace();
            }
            }

            @Override
            public void onFailure(Call<BooksModel> call, Throwable t) {

            }
        });
    }
}