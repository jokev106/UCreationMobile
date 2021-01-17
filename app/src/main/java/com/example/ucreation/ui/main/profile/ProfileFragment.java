package com.example.ucreation.ui.main.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ucreation.R;
import com.example.ucreation.ui.MainActivity;
import com.example.ucreation.ui.main.login.LoginViewModel;
import com.example.ucreation.util.SharedPreferenceHelper;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {

    @BindView(R.id.buttonlogout)
    Button btnlogout;


    private ProfileViewModel viewModel;
    private SharedPreferenceHelper helper;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);
        viewModel.init(helper.getAccessToken());
        Log.d("accesstoken", helper.getAccessToken());

        btnlogout.setOnClickListener(v -> {
            viewModel.logout().observe(requireActivity(), message ->{
                if(!message.isEmpty()){
                    helper.clearPref();
                    NavDirections action = ProfileFragmentDirections.actionProfileFragment2ToLoginFragment3();
                    Navigation.findNavController(view).navigate(action);
                    Toast.makeText(requireActivity(), "Logged Out", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}