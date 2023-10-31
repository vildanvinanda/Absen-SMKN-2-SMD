package com.example.belajarretrofit.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.Holder.HolderJadwal;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdaperCalendar  extends RecyclerView.Adapter<HolderJadwal> {

    private final ArrayList<LocalDate> days;
    private final OnItemListener onItemListener;

    public AdaperCalendar(ArrayList<LocalDate> days, OnItemListener onItemListener)
    {
        this.days = days;
        this.onItemListener = onItemListener;
    }

    @NotNull
    @Override
    public HolderJadwal onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if(days.size() > 15) //month view
            layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        else // week view
            layoutParams.height = (int) parent.getHeight();

        return new HolderJadwal(view, onItemListener, days);
    }

    @Override
    public void onBindViewHolder(@NotNull HolderJadwal holder, int position) {
        final LocalDate date = days.get(position);
        if(date == null)
        {
            holder.dayOfMonth.setText("");
//            holder.dayOfMonth.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.dayOfMonth.setText(String.valueOf(date.getDayOfMonth()));
            if(date.equals(CalendarUtils.selectedDate)) {
                holder.parentView.setBackgroundColor(Color.parseColor("#C7C9FF"));
                holder.dayOfMonth.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public interface  OnItemListener
    {

        void onSelectedDate(LocalDate date, ArrayList<LocalDate> days, int position);
        void onClick(View view);
        void onItemClick(int position, LocalDate date);
    }
}
