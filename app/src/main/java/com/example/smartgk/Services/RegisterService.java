package com.example.smartgk.Services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.smartgk.Retrofit.ApiClient;
import com.example.smartgk.Retrofit.ApiInterface;
import com.example.smartgk.model.UserModelRegistration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterService  extends IntentService {
    private static final String ACTION_REGISTER = "com.example.smartgk.services.action.REGISTER";

    private static final String EMAILR = "com.example.smartgk.services.extra.emailr";
    private static final String PASSWORDR = "com.example.smartgk.services.extra.passwordr";
    public static final String REGISTER_MESSAGE ="RegisterMessage" ;
    public static final String MESSAGE_KEY = "messager" ;

    ApiInterface apiInterface;

    public RegisterService(){
    super("RegisterService");
    }

    public static void startRegistration(Context context, String emailr, String passwordr){
        Intent intent= new Intent(context, RegisterService.class);
        intent.setAction(ACTION_REGISTER);
        intent.putExtra(EMAILR, emailr);
        intent.putExtra(PASSWORDR, passwordr);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_REGISTER.equals(action)) {
                final String email = intent.getStringExtra(EMAILR);
                final String password = intent.getStringExtra(PASSWORDR);
                handleActionRegistration(email, password);
            }

        }
    }

    private void handleActionRegistration(String email, String password) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<UserModelRegistration> call= apiInterface.userRegister(email, password);
        call.enqueue(new Callback<UserModelRegistration>() {
            @Override
            public void onResponse(Call<UserModelRegistration> call, Response<UserModelRegistration> response) {

                if (response.code() == 200) {
                    Toast.makeText(getApplicationContext(), response.body().getResults(), Toast.LENGTH_SHORT).show();
                }
                else if (response.code() == 400){
                Toast.makeText(getApplicationContext(), "Email already registered", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();

                }

            }
            @Override
            public void onFailure(Call<UserModelRegistration> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check Internet Connection!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
