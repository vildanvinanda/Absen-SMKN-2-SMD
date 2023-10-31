package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.text.BreakIterator;

public class HolderFAQ extends RecyclerView.ViewHolder {


    public TextView pertanyaan, jawaban;
    public ImageView rowrightfaq;
    public RelativeLayout jawabanbg;

    public HolderFAQ(@NonNull @NotNull View itemView) {
        super(itemView);

        pertanyaan = (TextView) itemView.findViewById(R.id.pertanyaan);
        jawaban = (TextView) itemView.findViewById(R.id.jawaban);
        rowrightfaq = (ImageView) itemView.findViewById(R.id.rowrightfaq);
        jawabanbg = (RelativeLayout) itemView.findViewById(R.id.jawabanbg);

    }
}
