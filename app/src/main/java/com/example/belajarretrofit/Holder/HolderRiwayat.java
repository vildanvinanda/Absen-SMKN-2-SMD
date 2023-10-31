package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

public class HolderRiwayat extends RecyclerView.ViewHolder {

    TextView txtjdl, txttgl;

    public HolderRiwayat(@NonNull @NotNull View itemView) {
        super(itemView);

        txtjdl = itemView.findViewById(R.id.txtjdl);
        txttgl = itemView.findViewById(R.id.txttgl);

    }
}
