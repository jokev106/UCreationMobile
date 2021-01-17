package com.example.ucreation.ui.splash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ucreation.R;
import com.example.ucreation.util.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SplashFragment extends Fragment {



    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferenceHelper helper = SharedPreferenceHelper.getInstance(requireActivity());

        new Handler().postDelayed(() -> {
            NavDirections action = SplashFragmentDirections.actionstologin();
            if (helper.getAccessToken().isEmpty()){
                // request ke api apakah tokenmu masih jalan atau tyduck(kalau tyduck send request lagi pake yang refresh token
                action = SplashFragmentDirections.actionstologin();
            } else{
                action = SplashFragmentDirections.actionSplashFragmentToNavCreation();
            }
            Navigation.findNavController(view).navigate(action);
        }, 1500);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();


    }
}