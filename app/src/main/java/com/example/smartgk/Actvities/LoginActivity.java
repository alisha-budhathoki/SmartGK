package com.example.smartgk.Actvities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartgk.Database.UserDetails;
import com.example.smartgk.Fragment.ProfileFragmentPackage.ProfileFragment;
import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.Services.LoginIntentService;
import com.example.smartgk.Viewmodel.LoginActivityViewModel;
import com.example.smartgk.utitlies.Constants;
import com.example.smartgk.utitlies.SharedPreferenceClass;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
    ProgressBar progressBar;
    SharedPreferences sharedPreferences;
    LoginActivityViewModel loginActivityViewModel;



    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           SharedPreferenceClass sharedPreferenceClass = new SharedPreferenceClass(context);
            UserDetails userDetails = intent.getParcelableExtra(LoginIntentService.MESSAGE_KEY);
            if(userDetails!=null) {
                System.out.println("UserDetail : "+userDetails.getName());
                loginActivityViewModel.saveVendorDetails(userDetails);
                progressBar.setVisibility(View.GONE);

                sharedPreferenceClass.saveData(userDetails.getId(), userDetails.getName(), userDetails.getEmail(), userDetails.getImage(),userDetails.getBio());
                sharedPreferenceClass.isLooggedIn(true);
                Toast.makeText(LoginActivity.this, "Login Sucessful",Toast.LENGTH_SHORT).show();

                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class) ;
                mainIntent.putExtra(Constants.USER_ID,userDetails.getId());
                startActivity(mainIntent);
                finish();
            }else {
                progressBar.setVisibility(View.GONE);
                emailL.setError("??");
            }


        }
    };







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
                if (validateform() == false) {
                    hideProgressBar();
                }
                else {
                    progressBar.setVisibility(View.VISIBLE);
                    loginActivityViewModel.loginUser(emailL.getText().toString(), passwordL.getText().toString());
                }
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



                            sharedPreferenceClass.saveData(object.optString("id"),name,email,url, null);
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

    private boolean validateform() {
    boolean valid= true;
    String getEmail= emailL.getText().toString();
    String getPassword = passwordL.getText().toString();
        if (getEmail.isEmpty() || !isEmailValid(getEmail)){
            emailL.setError("Enter a valid Email");
        }

        if (getPassword.isEmpty() ){
            passwordL.setError("Password field should not be empty");
            valid = false;
        }
        return valid;
    }

    private boolean isEmailValid(String getEmail) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(getEmail).matches();

    }

    private void hideProgressBar() {
progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(broadcastReceiver,
                        new IntentFilter(LoginIntentService.LOGIN_MESSAGE));

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
                sharedPreferenceClass.saveData(account.getId(),account.getDisplayName(),account.getEmail(),"", null);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }else{
                sharedPreferenceClass.isLooggedIn(true);
                sharedPreferenceClass.saveData(account.getId(),account.getDisplayName(),account.getEmail(),account.getPhotoUrl().toString(), null);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            System.out.println("TokenID : "+account.getId());
        }
    }

    private void intitWidgets() {
        emailL = findViewById(R.id.emailEdittextl);
        passwordL = findViewById(R.id.passwordEditextl);
        login = findViewById(R.id.login);
        frgt = findViewById(R.id.frgtTxt);
        gotoRegister = findViewById(R.id.registerAccount);
        here = findViewById(R.id.here);
        myFbSigninBtn = findViewById(R.id.fbIcon);
        myGoogleSigninBtn = findViewById(R.id.googleIcon);
        goHome = findViewById(R.id.goHomel);
        progressBar = findViewById(R.id.loginProgress);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        initViewModel();

    }

    private void initViewModel() {
        loginActivityViewModel= ViewModelProviders.of(this).get(LoginActivityViewModel.class);
    }



    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(broadcastReceiver);
    }


}
