package com.example.smartgk.Actvities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.publicAccess.Keys;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    EditText emailL, passwordL;
    Button login;
    TextView frgt, here, goHome, gotoRegister;
    CallbackManager mFacebookCallbackManager;
    private LoginButton mFacebookSignInButton;
    ImageView myFbSigninBtn, loginGoogleImg;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    ImageView myGoogleSigninBtn;
    GoogleSignInClient mGoogleSignInClient;
    String email,name,first_name,last_name;
    SharedPreferenceClass sharedPreferenceClass;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FacebookSdk.sdkInitialize(getApplicationContext());


        // This MUST be placed after the above two lines.

        setContentView(R.layout.activity_login);
        sharedPreferenceClass = new SharedPreferenceClass(getApplicationContext());

        sharedPref = getSharedPreferences(getPackageName(), MODE_PRIVATE);


        intitWidgets();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestId()
                .requestProfile()
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        myGoogleSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, REQ_CODE);
            }
        });

        myFbSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile"));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
            }
        });

        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetActivity.class);
                startActivity(intent);
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

        mFacebookCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("JSON", "" + response.getJSONObject().toString());

                        try {


                            name = object.optString("name");
                            first_name = object.optString("first_name");
                            last_name = object.optString("last_name");
                            JSONObject picture = object.getJSONObject("picture");
                            JSONObject data = picture.getJSONObject("data");
                            String url = data.optString("url");

                            System.out.println("Url : " + url);
                            System.out.println("Email : " + email);


                            if (object.has("email")) {

                                email = object.optString("email");

                            } else {
                                email = "";
                            }

                            if (url == null) {
                                url = "";
                            }



                            sharedPreferenceClass.saveData(object.optString("id"),name,email,url);
                            sharedPreferenceClass.isLooggedIn(true);

                            Intent goIntent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(goIntent);





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//Login bhayera aba uninstall garnu parchha
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,first_name,last_name,picture.type(large)");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Login Cancel", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        sharedPref = getSharedPreferences("Login",MODE_PRIVATE);


    }

    @Override
    public void onStart() {
        super.onStart();

        try {
            if (sharedPreferenceClass.isLoggedIn()){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            mFacebookCallbackManager.onActivityResult(requestCode,resultCode,data);
            super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE) {

            System.out.println("I am here!!!");

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount account = null;
            try {
                account = task.getResult(ApiException.class);
            } catch (ApiException e) {
                e.printStackTrace();
            }


            if (account.getPhotoUrl() == null){
                sharedPreferenceClass.isLooggedIn(true);
                sharedPreferenceClass.saveData(account.getId(),account.getDisplayName(),account.getEmail(),"");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }else{
                sharedPreferenceClass.isLooggedIn(true);
                sharedPreferenceClass.saveData(account.getId(),account.getDisplayName(),account.getEmail(),account.getPhotoUrl().toString());
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            System.out.println("TokenID : "+account.getId());
        }
    }

    private void intitWidgets() {
        emailL = findViewById(R.id.emailEdittextr);
        passwordL = findViewById(R.id.passwordEditextr);
        login = findViewById(R.id.login);
        frgt = findViewById(R.id.frgtTxt);
        gotoRegister = findViewById(R.id.registerAccount);
        here = findViewById(R.id.here);
        myFbSigninBtn = findViewById(R.id.fbIcon);
        myGoogleSigninBtn = findViewById(R.id.googleIcon);
        goHome = findViewById(R.id.goHomel);
    }
}
