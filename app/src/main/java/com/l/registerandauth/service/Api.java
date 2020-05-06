package com.l.registerandauth.service;

import com.l.registerandauth.models.DefaultResponse;
import com.l.registerandauth.models.LoginResponse;
import com.l.registerandauth.models.UsersResponse;

import java.security.Policy;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @FormUrlEncoded
    @POST("index.php")
    Call<DefaultResponse> createUser(
      @Field("email") String email,
      @Field("password") String password,
      @Field("name") String name,
      @Field("school") String school
    );


      @FormUrlEncoded
      @POST("login.php")
        Call<LoginResponse> userLogin(
                @Field("email") String email,
                @Field("password") String password

    );
    @GET("allusers.php")
    Call<UsersResponse> getUser();

    @FormUrlEncoded
    @POST("edit.php")
    Call<LoginResponse> updateUser(
            @Field("id") int id,
            @Field("email") String email,
            @Field("name") String name,
            @Field("school") String school
    );

    @FormUrlEncoded
    @POST("edit.php")
    Call<DefaultResponse> updatePassword(
            @Field("currentpassword") String currentpassword,
            @Field("newpassword") String newpassword,
            @Field("email") String email
    );
    @FormUrlEncoded
    @POST("delete.php")
    Call<DefaultResponse> deleteUser(
            @Field("id") int id
    );


}
