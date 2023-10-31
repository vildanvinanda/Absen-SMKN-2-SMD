package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

public class HolderEkskulUser extends RecyclerView.ViewHolder {

    public CardView card,card2,card3;
    public TextView txtEks, txtEks2, txtEks3;

    public HolderEkskulUser(@NotNull View itemView) {
        super(itemView);
        card = itemView.findViewById(R.id.card);
        card2 = itemView.findViewById(R.id.card2);
        card3 = itemView.findViewById(R.id.card3);
        txtEks = itemView.findViewById(R.id.txtEks);
        txtEks2 = itemView.findViewById(R.id.txtEks2);
        txtEks3 = itemView.findViewById(R.id.txtEks3);
    }
}
