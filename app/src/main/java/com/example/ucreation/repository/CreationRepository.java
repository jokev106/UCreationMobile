package com.example.ucreation.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucreation.model.local.Creation;
import com.example.ucreation.model.response.CreationResponse;
import com.example.ucreation.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreationRepository {

    private RetrofitService apiService;
    private static final String TAG = "CreationRepository";
    private static CreationRepository creationRepository;

    private CreationRepository(String token) {
        apiService = RetrofitService.getInstance(token);
    }

    public static CreationRepository getInstance(String token) {
        if (creationRepository == null) {
            creationRepository = new CreationRepository(token);
        }
        return creationRepository;
    }

    public synchronized void resetInstance() {
        if (creationRepository != null) {
            creationRepository = null;
        }
    }

    public MutableLiveData<List<Creation>> getCreations() {
        MutableLiveData<List<Creation>> liveEvents = new MutableLiveData<>();

        apiService.getCreations().enqueue(new Callback<CreationResponse>() {
            @Override
            public void onResponse(Call<CreationResponse> call, Response<CreationResponse> response) {
                Log.d(TAG, "onResponse" + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        liveEvents.postValue(response.body().getResults());
                    }
                }

            }

            @Override
            public void onFailure(Call<CreationResponse> call, Throwable t) {
                Log.d(TAG, "onFailure" + t.getMessage());
            }
        });
        return liveEvents;
    }
}
