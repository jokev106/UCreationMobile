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

import butterknife.BindView;
import butterknife.ButterKnife;


public class SplashFragment extends Fragment {


    @BindView(R.id.btncreation)
    Button button;


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



        new Handler().postDelayed(() -> {
            NavDirections action = SplashFragmentDirections.actionstologin();
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

        ButterKnife.bind(this, view);

        button.setOnClickListener(v -> {
            NavDirections action = SplashFragmentDirections.actionSplashFragmentToCreationFragment();
            Navigation.findNavController(view).navigate(action);
        });

    }
}