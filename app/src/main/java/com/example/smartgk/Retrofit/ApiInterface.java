package com.example.smartgk.Retrofit;

import com.example.smartgk.model.BooksModel;
import com.example.smartgk.model.Home_Model.HomeModel;
import com.example.smartgk.model.Home_model_real.HomeModel2;
import com.example.smartgk.model.NewsModel;
import com.example.smartgk.model.UserLoginModel;
import com.example.smartgk.model.UserModelRegistration;
import com.example.smartgk.model.UserProfileModel;
import com.example.smartgk.model.user_model.UserModelClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<UserLoginModel> userLogin(@Field("email") String username,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<UserModelRegistration> userRegister(@Field("email") String email,
                                             @Field("password") String password);


    @GET("get-all-books")
    Call<BooksModel> getBooks();

    @GET("get-all-news")
    Call<NewsModel> getNews();

    @GET("userProfile/{id}")
    Call<UserModelClass> getUserProfile(@Path("id") String id);

    @GET("get-home")
    Call<HomeModel2> getHomePage();
}
