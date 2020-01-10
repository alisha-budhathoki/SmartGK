package com.example.smartgk.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static ApiInterface apiInterface = null;

    private static final String BASE_URL = "http://cosmicnepal.com/client/newsmartgk/smartgk/api/api/";

    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retrofit == null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static void makeApiInterface() {
        if (retrofit == null)
            getApiClient();

        if (apiInterface == null)
            apiInterface = retrofit.create(ApiInterface.class);
    }

}
