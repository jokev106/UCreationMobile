package com.example.ucreation.ui.main.creation;

import android.graphics.Movie;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.ucreation.R;
import com.example.ucreation.model.local.Creation;
import com.example.ucreation.util.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.List;


public class CreationFragment extends Fragment {

    @BindView(R.id.rv_creation)
    RecyclerView rvCreation;

    private CreationViewModel viewModel;
    private CreationAdapter adapter;
    private SharedPreferenceHelper helper;

    public CreationFragment() {
        // Required empty public constructor
    }
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_creation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = new CreationAdapter(getContext());

        rvCreation.setLayoutManager(new LinearLayoutManager(getActivity()));

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(CreationViewModel.class);
        viewModel.init(helper.getAccessToken());
        viewModel.getCreations().observe(requireActivity(), observeViewModel);
    }

    private Observer<List<Creation>> observeViewModel = creations -> {
        if (creations != null){
            adapter.setListcreation(creations);
            adapter.notifyDataSetChanged();
            rvCreation.setAdapter(adapter);
        }
    };


}