package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

public class HolderPiala extends RecyclerView.ViewHolder {

    public ImageView imgp;
    public TextView txtjdl, txttgl;


    public HolderPiala(@NotNull View itemView) {
        super(itemView);
        imgp = itemView.findViewById(R.id.imgp);
        txtjdl = itemView.findViewById(R.id.txtjdl);
        txttgl = itemView.findViewById(R.id.txttgl);
    }
}
