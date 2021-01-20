package com.example.ucreation.network;

import com.example.ucreation.model.response.CreationResponse;
import com.example.ucreation.model.response.ProfileResponse;
import com.example.ucreation.model.response.TokenResponse;
import com.example.ucreation.util.Constants;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private final ApiEndpoints api;
    private static RetrofitService service;

    private RetrofitService(String token) {

        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (token.equals("")) {
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build();
                return chain.proceed(request);
            });
        } else {
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", token).build();
                return chain.proceed(request);
            });

        }

        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
                .create(ApiEndpoints.class);
    }

    public static RetrofitService getInstance(String token) {
        if (service == null) {
            service = new RetrofitService(token);
        } else if (!token.equals("")) {
            service = new RetrofitService(token);
        }
        return service;
    }

//    public static RetrofitService getInstance() {
//        return service;
//    }

    public Call<TokenResponse> login(String email, String password) {
        return api.login(email, password);
    }


    public Call<JsonObject> logout() {

        return api.logout();
    }

    public Call<CreationResponse> getCreations() {
        return api.getCreations();
    }

    public Call<ProfileResponse> getProfiles() {
        return api.getProfiles();
    }
}
