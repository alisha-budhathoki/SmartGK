package com.example.smartgk.Actvities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.smartgk.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.jar.Attributes;

public class LoginActivityMain extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener{

    private ConstraintLayout profileSection;
    private Button sigonOut, goToProfile;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    SignInButton btnSignIn;
   private TextView Name, Email;
   private ImageView prof_pic;

   private GoogleApiClient googleApiClient;
   private static final int REQ_CODE = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);


        btnSignIn = (SignInButton) findViewById(R.id.googleLogIn);
        sigonOut = findViewById(R.id.signOut);
        profileSection = findViewById(R.id.profileSection);
        btnSignIn = findViewById(R.id.googleLogIn);
        Name = findViewById(R.id.nameProfile);
        Email = findViewById(R.id.emailProfile);
        prof_pic = findViewById(R.id.imageProfile);
        btnSignIn.setOnClickListener(this);
        sigonOut.setOnClickListener(this);
        profileSection.setVisibility(View.GONE);
        goToProfile = findViewById(R.id.goProfile);
        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(getApplicationContext(), HomePage.class);
                startActivity(profile);

            }
        });


        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.googleLogIn:
                signIn();

            case R.id.signOut:
                signOut();


        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn(){
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, REQ_CODE);
    }

    private void signOut(){
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUi(false);
            }
        });

    }

    private void handleResult(GoogleSignInResult result){
        if (result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            String img_url = account.getPhotoUrl().toString();
            Name.setText(name);
            Email.setText(email);
            Glide.with(this).load(img_url).into(prof_pic);

            sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            editor = sharedPref.edit();
            editor.putString("username", name);
            editor.apply();




            //updateUi(true);

        }
        else {
           // updateUi(false);
        }
    }

    private void updateUi(boolean isLogin){
        if(isLogin){
            profileSection.setVisibility(View.VISIBLE);
            btnSignIn.setVisibility(View.GONE);
            goToProfile.setVisibility(View.VISIBLE);
        }
        else {
            profileSection.setVisibility(View.GONE);
            btnSignIn.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
           // handleResult(result);
        }
    }
}
