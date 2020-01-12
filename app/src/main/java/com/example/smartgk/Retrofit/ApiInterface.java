package com.example.smartgk.Retrofit;

import com.example.smartgk.model.UserLoginModel;
import com.example.smartgk.model.UserModelRegistration;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<UserLoginModel> userLogin(@Field("email") String username,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<UserModelRegistration> userRegister(@Field("email") String email,
                                             @Field("password") String password);
}
