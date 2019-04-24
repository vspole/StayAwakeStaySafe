package com.staysafe.stayawake.visha.stayawakestaysafepub;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences settings = getSharedPreferences(HomeScreen.PREFS_NAME, 0);
                boolean hasrun = settings.getBoolean("run", false);
                if (hasrun == true) {
                    startActivity(new Intent(LoadingActivity.this, StartDriving.class));
                } else {
                    startActivity(new Intent(LoadingActivity.this, HomeScreen.class));
                }
            }
        }, 2000);

    }
}
