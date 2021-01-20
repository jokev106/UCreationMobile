package com.example.ucreation.ui.main.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ucreation.R;
import com.example.ucreation.model.local.Creation;
import com.example.ucreation.ui.MainActivity;
import com.example.ucreation.util.SharedPreferenceHelper;


import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {

    @BindView(R.id.JudulProject)
    TextView judulproject;

    @BindView(R.id.DeskripsiProject)
    TextView descproject;

    @BindView(R.id.DateProject)
    TextView dateproject;

    @BindView(R.id.img_project)
    ImageView detailimgproject;

    private Creation creation;
    private DetailViewModel viewModel;
    private SharedPreferenceHelper helper;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(DetailViewModel.class);
        viewModel.init(helper.getAccessToken());
        if (getArguments() != null) {
            creation = DetailFragmentArgs.fromBundle(getArguments()).getCreation();
            loadCreation(view, creation);
        }
    }

    private void loadCreation(View view, Creation creation) {
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setTitle(creation.getName());
//        Glide.with(getActivity()).load(creation.getPicture()).into(detailimgproject);
        judulproject.setText(creation.getName());
        descproject.setText(creation.getLong_desc());
        dateproject.setText(creation.getDate());
    }


}