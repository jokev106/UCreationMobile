package com.example.ucreation.model.response;

import com.example.ucreation.model.local.Creation;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreationResponse {
    @SerializedName("data")
    private List<Creation> results;

    public List<Creation> getResults() {
        return results;
    }
}
