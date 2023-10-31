package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.belajarretrofit.Adapter.AdaperCalendar;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class HolderJadwal extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ArrayList<LocalDate> days;
    public final View parentView;
    public final TextView dayOfMonth;
    private final AdaperCalendar.OnItemListener onItemListener;

    public HolderJadwal(@NotNull View itemView, AdaperCalendar.OnItemListener onItemListener, ArrayList<LocalDate> days) {
        super(itemView);
        parentView = itemView.findViewById(R.id.parentView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
        this.days = days;
    }

    @Override
    public void onClick(View view)
    {
        onItemListener.onItemClick(getAdapterPosition(), days.get(getAdapterPosition()));
    }

//    public TextView txtjdl, txtjam, txttempat;
//
//
//    public HolderJadwal(@NotNull View itemView, OnItemListener onItemListener, ArrayList<LocalDate> days) {
//        super(itemView);
//
//        txtjdl = itemView.findViewById(R.id.txtjdl);
//        txtjam = itemView.findViewById(R.id.txtjam);
//        txttempat = itemView.findViewById(R.id.txttempat);
//    }
}
