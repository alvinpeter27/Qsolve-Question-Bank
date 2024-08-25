package com.example.qsolve;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class forgot_password_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        loadFragment(new forgot_passwordFragment());
    }

    private boolean loadFragment(forgot_passwordFragment forgotPasswordFragment) {
        if (forgotPasswordFragment!= null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.forgot_framelayout,forgotPasswordFragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

}
