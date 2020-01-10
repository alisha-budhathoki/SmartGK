package com.example.smartgk.Services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.smartgk.Actvities.LoginActivity;
import com.example.smartgk.Database.UserDetails;
import com.example.smartgk.Retrofit.ApiClient;
import com.example.smartgk.Retrofit.ApiInterface;
import com.example.smartgk.model.UserLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginIntentService extends IntentService {
    private static final String ACTION_LOGIN = "com.example.smartgk.services.action.LOGIN";

    private static final String EMAIL = "com.example.smartgk.services.extra.username";
    private static final String PASSWORD = "com.example.smartgk.services.extra.password";
    public static final String LOGIN_MESSAGE ="LoginMessage" ;
    public static final String MESSAGE_KEY = "message" ;

    ApiInterface mApiInterface;



    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public LoginIntentService() {
        super("LoginIntentService");
    }

    public static void startActionLogin(Context context, String email, String password) {
        Intent intent = new Intent(context, LoginIntentService.class);
        intent.setAction(ACTION_LOGIN);
        intent.putExtra(EMAIL, email);
        intent.putExtra(PASSWORD, password);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_LOGIN.equals(action)) {
                final String email = intent.getStringExtra(EMAIL);
                final String password = intent.getStringExtra(PASSWORD);
                handleActionLogin(email, password);
            }

        }
    }

    private void handleActionLogin(String email, String password) {
        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<UserLoginModel> call= mApiInterface.userLogin(email, password);
        call.enqueue(new Callback<UserLoginModel>() {
            @Override
            public void onResponse(Call<UserLoginModel> call, Response<UserLoginModel> response) {


                if (response.code() == 200) {


                    sendMessage(new UserDetails(response.body().getResults().getId(),
                            response.body().getResults().getName(),
                            response.body().getResults().getImage(),
                            response.body().getResults().getBio(),
                            response.body().getResults().getAddress(),
                            response.body().getResults().getEmail(),
                            response.body().getResults().getPhone_no(),
                            response.body().getResults().getSlug(),
                            response.body().getResults().getValidation(),
                            response.body().getResults().getCreated_at(),
                            response.body().getResults().getUpdated_at()));
                }

                else {
                    sendMessage(null);
                    Toast.makeText(getApplicationContext(), "Wrong Credentials!!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserLoginModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check Internet Connection!!!", Toast.LENGTH_SHORT).show();
                sendMessage(null);

                t.printStackTrace();
            }
        });
    }

    private void sendMessage(UserDetails userDetails) {
        Intent intent= new Intent(LOGIN_MESSAGE);
        intent.putExtra(MESSAGE_KEY, userDetails);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

    }

}
