package com.example.ucreation.network;

import com.example.ucreation.model.response.CreationResponse;
import com.example.ucreation.model.response.TokenResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndpoints {
    @POST("api-login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("api-logout")
    Call<JsonObject> logout();

    @GET("creations")
    Call<CreationResponse> getCreations();

}
