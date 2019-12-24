package com.example.smartgk.Actvities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartgk.R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

public class HomePage extends AppCompatActivity {
    public static final String GOOGLE_ACCOUNT = "google_account";
    private TextView profileName, profileEmail, fbUsername;
    private ImageView profileImage;
    private Button signOut;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String profNam;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        profileName = findViewById(R.id.profile_text);
        profileEmail = findViewById(R.id.profile_email);
        profileImage = findViewById(R.id.profile_image);
        fbUsername = findViewById(R.id.usernamefb);

        signOut=findViewById(R.id.sign_out);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String value = sharedPreferences.getString("username","");
        profileName.setText(value);
        Log.e("profileName",value);


        String value2 = sharedPreferences.getString("first_name","");
        fbUsername.setText(value2);


    }



}
