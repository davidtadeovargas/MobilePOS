package net.tecgurus.mobilepos.controllers.activities;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import net.tecgurus.mobilepos.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity=this;
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                final Intent intent = new Intent(activity,LoginActivity.class);
                startActivity(intent);
            }
        }, 3000L);
        }
    }

