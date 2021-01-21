package com.example.ucreation.ui.main.creation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Movie;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ucreation.R;
import com.example.ucreation.model.local.Creation;

import java.util.ArrayList;
import java.util.List;

public class CreationAdapter extends RecyclerView.Adapter<CreationAdapter.CardViewViewHolder> {

    private final Context context;
    private List<Creation> listCreation;
    private List<Creation> getListcreation() {
        return listCreation;
    }
    public void setListcreation(List<Creation> listCreation) {
        this.listCreation = listCreation;
    }
    public CreationAdapter(Context context) {
        this.listCreation = new ArrayList<Creation>();
        this.context = context;
    }

    @NonNull
    @Override
    public CreationAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_creation, parent, false);
        return new CreationAdapter.CardViewViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final CreationAdapter.CardViewViewHolder holder, int position) {
        Creation creation = getListcreation().get(position);
        Glide.with(context).load(creation.getPicture()).centerCrop().into(holder.img);
        holder.projectname.setText(creation.getName());
        holder.itemView.setOnClickListener(view -> {
            NavDirections action = CreationFragmentDirections.actionCreationFragment2ToDetailFragment2(creation);
            Navigation.findNavController(view).navigate(action);
        });
        Log.d("Creation",creation.getPicture());
    }

    @Override
    public int getItemCount() {
        return getListcreation().size();
    }


    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView projectname;

        CardViewViewHolder(View itemView) {
            super(itemView);
            projectname = itemView.findViewById(R.id.projectnames);
            img = itemView.findViewById(R.id.img_creation);
        }
    }
}
