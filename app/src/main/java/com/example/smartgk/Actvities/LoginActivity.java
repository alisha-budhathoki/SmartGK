package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartgk.R;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    TextView frgt, crtAcnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intitWidgets();

        crtAcnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    private void intitWidgets() {
        email = findViewById(R.id.emailEdittextr);
        password = findViewById(R.id.passwordEditextr);
        login = findViewById(R.id.login);
        frgt = findViewById(R.id.frgtTxt);
        crtAcnt = findViewById(R.id.crtAcnt);
    }
}
