package com.exam.entranceinew.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.exam.entranceinew.R;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    public void onClick(View view) {
        switch (view.getId()){

                case R.id.tv_register:
                    Intent intent = new Intent(SplashScreen.this, Signup.class);
                    startActivity(intent);
                    break;

                case R.id.tv_login:
                    Intent intent1 = new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(intent1);
                    break;
        }
    }
}
