package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

public class HolderViewAbsen extends RecyclerView.ViewHolder {

    public TextView tgl, jml;
    public RecyclerView recabsen;
    public ImageView rowrightfaq;

    public HolderViewAbsen(@NotNull View itemView) {
        super(itemView);
        tgl = itemView.findViewById(R.id.tgl);
        recabsen = itemView.findViewById(R.id.recabsen);
        jml = itemView.findViewById(R.id.jml);
        rowrightfaq = itemView.findViewById(R.id.rowrightfaq);
    }
}
