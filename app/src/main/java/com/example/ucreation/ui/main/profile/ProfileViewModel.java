package com.example.ucreation.ui.main.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucreation.model.local.Creation;
import com.example.ucreation.model.local.Profile;
import com.example.ucreation.repository.ProfileRepository;

import java.util.List;

public class ProfileViewModel extends ViewModel {

    private ProfileRepository repository;

    public ProfileViewModel() {

    }

    public void init(String token) {
        repository = ProfileRepository.getInstance(token);
    }

    public LiveData<String> logout() {
        return repository.logout();
    }

    public LiveData<List<Profile>> getProfiles() {
        return repository.getProfiles();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.resetInstance();
    }
}
