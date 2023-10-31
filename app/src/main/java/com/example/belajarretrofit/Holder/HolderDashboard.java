package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

public class HolderDashboard extends RecyclerView.ViewHolder {

    public ImageView img;

    public HolderDashboard(@NotNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.img);

    }
}
