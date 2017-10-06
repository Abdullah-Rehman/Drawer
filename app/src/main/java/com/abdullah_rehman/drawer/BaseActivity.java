package com.abdullah_rehman.drawer;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        sessionManager = new SessionManager(BaseActivity.this);
        if(sessionManager.isLoggedIn()){
            Intent myIntent = new Intent(BaseActivity.this, MainActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myIntent);
            this.finish();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.baseContainer, new LoginFragment()).addToBackStack("").commit();
    }
}
