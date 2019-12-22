package com.example.smartgk.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;

import com.example.smartgk.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
Timer timer;
    Handler handler;
    Runnable runnable;
    LocationManager locationManager;
    String provider, formattedDate, imeid;
    double lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);



        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        formattedDate = df.format(c.getTime());



        new Handler().postDelayed(new Runnable() {
            public void run() {
                Log.i("JO", "run");
                Intent in = new Intent(SplashActivity.this,LoginActivity.class);
                //in.putExtra("refreshclick", clickRefreshButton);
                //in.putExtra("Current_Date", formattedDate);
                //  in.putExtra("ImeiId", imeid);
//Log.i("JO", "Current_Date"+formattedDate+";
                startActivity(in);

                finish();
            }
        }, 2000);

    }



}
