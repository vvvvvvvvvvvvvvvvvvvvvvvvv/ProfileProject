package com.l.registerandauth.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.l.registerandauth.R;
import com.l.registerandauth.models.User;

public class ChatActivity extends AppCompatActivity {
        User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        user = intent.getParcelableExtra("userData");
        Log.d("test", user.getEmail());
    }
}
