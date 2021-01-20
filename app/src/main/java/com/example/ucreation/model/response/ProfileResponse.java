package com.example.ucreation.model.response;

import com.example.ucreation.model.local.Creation;
import com.example.ucreation.model.local.Profile;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileResponse {

    @SerializedName("data")
    private List<Profile> results;

    public List<Profile> getResults() {
        return results;
    }
}
