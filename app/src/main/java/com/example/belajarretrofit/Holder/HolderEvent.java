package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

public class HolderEvent extends RecyclerView.ViewHolder implements View.OnClickListener  {

    public TextView txtjdl, txtjam, txttempat;

    public HolderEvent(@NotNull View itemView) {
        super(itemView);

        txtjam = itemView.findViewById(R.id.txtjam);
        txtjdl = itemView.findViewById(R.id.txtjdl);
        txttempat = itemView.findViewById(R.id.txttempat);



    }

    @Override
    public void onClick(View v) {

    }
}
