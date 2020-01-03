package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.smartgk.R;

public class EditProfileActivity extends AppCompatActivity {
EditText editProfBio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        editProfBio = findViewById(R.id.editProfBio);
//        editProfBio.setHint("Enter your boi here");

    }
}
