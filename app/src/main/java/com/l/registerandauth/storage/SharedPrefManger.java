package com.l.registerandauth.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.l.registerandauth.models.User;

public class SharedPrefManger {
    private static final  String SHARED_PREF_NAME = "my_shared_preff";
    private static  SharedPrefManger mInstance;
    private Context mCtx;
    private SharedPrefManger(Context mCtx){
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManger getInstance(Context mCtx){
        if(mInstance == null){
            mInstance = new SharedPrefManger(mCtx);
        }
        return mInstance;
    }
    public void saveUser(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putString("email", user.getEmail());
        editor.putString("name", user.getName());
        editor.putString("school", user.getSchool());

        editor.apply();
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }
    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("name", null),
                sharedPreferences.getString("school", null)

        );

    }
    public void clear(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
