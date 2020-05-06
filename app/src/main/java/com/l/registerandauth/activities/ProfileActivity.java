package com.l.registerandauth.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.l.registerandauth.R;
import com.l.registerandauth.fragments.HomeFragment;
import com.l.registerandauth.fragments.SettingsFragment;
import com.l.registerandauth.fragments.UsersFragment;
import com.l.registerandauth.storage.SharedPrefManger;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);
        displayFragment(new HomeFragment());
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPrefManger.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_users:
                fragment = new UsersFragment();
                break;
            case R.id.menu_settings:
                fragment = new SettingsFragment();
                break;

        }
        if(fragment != null){
            displayFragment(fragment);
        }
        return false;
    }
}
