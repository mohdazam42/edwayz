package com.edwayzapp.edwayz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.edwayzapp.utils.Constants;
import com.edwayzapp.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    int SPLASH_TIME_OUT = 2000;
    String isLogin = "FALSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashTimeOut();
    }

    private void splashTimeOut() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isLogin = Utils.getSharedPref(SplashActivity.this, Constants.KEY_IS_LOGIN, null);
                if (isLogin != null && isLogin.equalsIgnoreCase("TRUE")) {
                    startActivity(new Intent(SplashActivity.this, SelClassActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}
