package com.l.registerandauth.service;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static RetrofitClient mInstance;

    private static String BASE_URL = "http://10.0.3.2/game/";


    public  RetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }






    }
    public static synchronized RetrofitClient getInstance(){
        if(mInstance == null){
            mInstance = new RetrofitClient();
        }
        return  mInstance;
    }
    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
