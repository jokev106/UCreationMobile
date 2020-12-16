package com.example.ucreation.ui.main.creation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ucreation.R;
import com.example.ucreation.ui.splash.SplashFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreationFragment extends Fragment {

    @BindView(R.id.buttontodetail)
    Button button;

    public CreationFragment() {
        // Required empty public constructor
    }
        

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        button.setOnClickListener(v -> {
            NavDirections action = CreationFragmentDirections.actionCreationFragmentToDetailFragment();
            Navigation.findNavController(view).navigate(action);
        });



    }
}