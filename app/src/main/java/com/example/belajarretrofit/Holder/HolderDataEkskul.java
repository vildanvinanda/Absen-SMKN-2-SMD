package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

public class HolderDataEkskul extends RecyclerView.ViewHolder {

    public ImageView img2;

    public TextView txtjdl2, txtisi2, txttotal2;

    public HolderDataEkskul(@NotNull View itemView) {
        super(itemView);

        img2 = itemView.findViewById(R.id.img2);
        txtjdl2 = itemView.findViewById(R.id.txtjdl2);
        txtisi2 = itemView.findViewById(R.id.txtisi2);
        txttotal2 = itemView.findViewById(R.id.txttotal2);
    }
}
