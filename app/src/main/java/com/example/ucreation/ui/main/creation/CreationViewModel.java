package com.example.ucreation.ui.main.creation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucreation.model.local.Creation;
import com.example.ucreation.repository.CreationRepository;

import java.util.List;

public class CreationViewModel  extends ViewModel {

    private CreationRepository repository;

    public CreationViewModel(){

    }
//    public CreationViewModel(String token) {
//        repository = CreationRepository.getInstance(token);
//    }
    public void init(String token){
        repository = CreationRepository.getInstance(token);
    }

    public LiveData<List<Creation>> getCreations(){
        return repository.getCreations();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.resetInstance();
    }
}
