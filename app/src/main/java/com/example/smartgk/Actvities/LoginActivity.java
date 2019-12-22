package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartgk.MainActivity;
import com.example.smartgk.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Apple";
    EditText email, password;
    Button login;
    TextView frgt, crtAcnt, here;
    CallbackManager mFacebookCallbackManager;
    private LoginButton mFacebookSignInButton;
    Exception exception;
    ImageView loginImg;
    SignInButton googleSignIn;
    GoogleSignInClient mGoogleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        mFacebookCallbackManager = CallbackManager.Factory.create();

        // This MUST be placed after the above two lines.

        setContentView(R.layout.activity_login);

        intitWidgets();

        crtAcnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        loginImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile"));

            }
        });

        //For facebook login
        mFacebookSignInButton = (LoginButton) findViewById(R.id.facebook_sign_in_button);

        List<String> permissionNeeds = Arrays.asList("public_profile", "AccessToken");
        mFacebookSignInButton.registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                System.out.println("onSucess");
                String acessToken = loginResult.getAccessToken().getToken();
                Log.i("accessToken", acessToken);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

                System.out.println("onError");
                Log.v("LoginActivity", exception.getCause().toString());
            }
        });


    //Google sign in
        googleSignIn = findViewById(R.id.googel_sign_in_button);
        googleSignIn.setSize(SignInButton.SIZE_STANDARD);
        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInGoogle();
            }
        });

    }

    private void signInGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 101);

    }

    @Override

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }

    }

    private void updateUI(GoogleSignInAccount account) {
        Intent intent = new Intent(this, ProfileActivityFromGoogle.class);
        intent.putExtra(ProfileActivityFromGoogle.GOOGLE_ACCOUNT, account);

        startActivity(intent);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (alreadyloggedAccount != null) {
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
            updateUI(alreadyloggedAccount);
        } else {
            Log.d(TAG, "Not logged in");
        }
    }

    public void onClick(View v) {
        if (v == loginImg) {
            LoginManager.getInstance().logInWithReadPermissions(
                    this,
                    Arrays.asList("user_photos", "email", "user_birthday", "public_profile")
            );
        }
    }

    


    private void intitWidgets() {
        email = findViewById(R.id.emailEdittextr);
        password = findViewById(R.id.passwordEditextr);
        login = findViewById(R.id.login);
        frgt = findViewById(R.id.frgtTxt);
        crtAcnt = findViewById(R.id.crtAcnt);
        here = findViewById(R.id.here);
        loginImg = findViewById(R.id.fbIcon);
    }
}
