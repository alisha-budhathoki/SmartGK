package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.example.smartgk.Services.RegisterService;
import com.example.smartgk.Viewmodel.RegisterViewmodel;
import com.example.smartgk.utitlies.SharedPreferenceClass;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity {
    EditText regEmail, regPasswd, regCPasswd;
    Button reigstrBtn;
    TextView goToLogin, goHomeFromRegister;
    SharedPreferences sharedPref;
    SharedPreferenceClass sharedPreferenceClass;
    GoogleSignInClient mGoogleSignInClient;
    ImageView googlelogor, facebooklogor;
    private static final int REQ_CODE = 9001;
    CallbackManager mFacebookCallbackManager;
    String email,name,first_name,last_name;
    ProgressBar progressBar;
    View view;
    String userEmail, userPassword;
    RegisterViewmodel registerctivityViewmodel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedPreferenceClass = new SharedPreferenceClass(getApplicationContext());

        FacebookSdk.sdkInitialize(getApplicationContext());

        sharedPref = getSharedPreferences(getPackageName(), MODE_PRIVATE);



        initWidgets();
        initViewModel();

        reigstrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (validateform() == false){
                hideProgressBar();
            }

            else {
                registerctivityViewmodel.registerUsers(regEmail.getText().toString(), regPasswd.getText().toString());
                showProgressbar();

            }
            }
        });



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestId()
                .requestProfile()
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        goHomeFromRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        googlelogor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, REQ_CODE);
            }
        });

        facebooklogor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(RegisterActivity.this, Arrays.asList("public_profile"));

            }
        });

        mFacebookCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
//                        Log.d("JSON", "" + response.getJSONObject().toString());
                        System.out.println("JsonFB : "+response.getJSONObject().toString());

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
                Toast.makeText(RegisterActivity.this, "Login Cancel", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(RegisterActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        sharedPref = getSharedPreferences("Login",MODE_PRIVATE);


    }

    private void initViewModel() {
        registerctivityViewmodel = ViewModelProviders.of(this).get(RegisterViewmodel.class);

    }

    private void showProgressbar() {
        progressBar.setVisibility(view.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(view.GONE);
    }

    private boolean validateform() {
        boolean valid = true;
        String emailR = regEmail.getText().toString();
        String passwordR = regPasswd.getText().toString();
        String cPasswordR = regCPasswd.getText().toString();

        if (emailR.isEmpty() || !isEmailValid(emailR)){
            regEmail.setError("Enter a valid Email");
        }
        if (passwordR.isEmpty() || regPasswd.length() <4 || regPasswd.length() >10){
            regPasswd.setError("Enter between 4 and 10 alphanumeric characters");
            valid = false;
        }



        if(cPasswordR.isEmpty() || cPasswordR.length()<4||cPasswordR.length()>10 ||!(cPasswordR.equals(passwordR))) {
            regCPasswd.setError("Password do not match");
            valid = false;
        }
        else {
            regCPasswd.setError(null);
        }


        return valid;
    }

    private boolean isEmailValid(String emailV) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(emailV).matches();

    }


    private void initWidgets() {
        regEmail = findViewById(R.id.emailEdittextr);
        regPasswd = findViewById(R.id.passwordEditextr);
        regCPasswd = findViewById(R.id.confpwdEdtTxtr);
        reigstrBtn = findViewById(R.id.registerBtn);
        goToLogin = findViewById(R.id.gotoLogn);
        goHomeFromRegister = findViewById(R.id.goHomer);
        googlelogor = findViewById(R.id.google_plusIconr);
        facebooklogor = findViewById(R.id.fbIconr);
        progressBar = findViewById(R.id.registerProgress);
    }

}
