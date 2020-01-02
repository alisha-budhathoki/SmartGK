package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartgk.R;

public class RegisterActivity extends AppCompatActivity {
    EditText regEmail, passwd, cPasswd;
    Button reigstrBtn;
    TextView goToLogin, goHomeFromRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initWidgets();
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        reigstrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
               startActivity(intent);
            }
        });
        goHomeFromRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initWidgets() {
        regEmail = findViewById(R.id.emailEdittextr);
        passwd = findViewById(R.id.passwordEditextr);
        cPasswd = findViewById(R.id.confpwdEdtTxt);
        reigstrBtn = findViewById(R.id.registerBtn);
        goToLogin = findViewById(R.id.gotoLogn);
        goHomeFromRegister = findViewById(R.id.goHomer);

    }

}
