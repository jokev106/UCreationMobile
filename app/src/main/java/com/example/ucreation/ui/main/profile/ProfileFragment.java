package com.example.ucreation.ui.main.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ucreation.R;
import com.example.ucreation.model.local.Profile;
import com.example.ucreation.ui.MainActivity;
import com.example.ucreation.util.SharedPreferenceHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {

    @BindView(R.id.button_logout)
    Button btnlogout;

    @BindView(R.id.username_profile)
    TextView username;

    @BindView(R.id.email_profile)
    TextView email;


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
        viewModel.getProfiles().observe(requireActivity(), observeViewModel);
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

    private Observer<List<Profile>> observeViewModel = new Observer<List<Profile>>() {
        @Override
        public void onChanged(List<Profile> profiles) {
            if (profiles != null){
                Profile profile = profiles.get(0);
                username.setText(profile.getName());
                email.setText(profile.getEmail());

            }
        }
    };

}