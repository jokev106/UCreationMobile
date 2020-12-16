package com.example.ucreation.ui.main.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucreation.model.response.TokenResponse;
import com.example.ucreation.repository.AuthRepository;

public class LoginViewModel extends ViewModel {
    private AuthRepository repository;

    public LoginViewModel() {
        repository = AuthRepository.getInstance();
    }

    public MutableLiveData<TokenResponse> login(String email, String password){
        return repository.login(email, password);
    }
}

