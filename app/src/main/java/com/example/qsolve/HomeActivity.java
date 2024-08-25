package com.example.qsolve;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        loadFragment(new HomeFragment());

    }

    private boolean loadFragment(HomeFragment homeFragment) {

        if (homeFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Home_frameLayout, homeFragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

}
