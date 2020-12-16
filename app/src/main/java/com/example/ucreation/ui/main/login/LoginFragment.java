package com.example.ucreation.ui.main.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ucreation.R;
import com.example.ucreation.model.response.TokenResponse;
import com.example.ucreation.ui.MainActivity;
import com.example.ucreation.ui.main.detail.DetailFragmentDirections;
import com.example.ucreation.util.SharedPreferenceHelper;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import com.example.ucreation.R;


public class LoginFragment extends Fragment {


    @BindView(R.id.loginBtn)
    Button buttonlogin;

    @BindView(R.id.login_email)
    EditText etemail;

    @BindView(R.id.login_password)
    EditText etpassword;

    private LoginViewModel viewModel;
    private SharedPreferenceHelper helper;

    public LoginFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        viewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel.class);
        helper = SharedPreferenceHelper.getInstance(requireActivity());

        buttonlogin.setOnClickListener(v -> {
            if (!etemail.getText().toString().isEmpty() && !etpassword.getText().toString().isEmpty()) {
                String email = etemail.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                viewModel.login(email, password).observe(requireActivity(), new Observer<TokenResponse>() {
                    @Override
                    public void onChanged(TokenResponse tokenResponse) {
                        if (tokenResponse != null) {
                            helper.saveAccessToken(tokenResponse.getAuthorization());
                            NavDirections actions = LoginFragmentDirections.actionLoginFragmentToCreationFragment2();
                            Navigation.findNavController(view).navigate(actions);
                            Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
    }
}


  