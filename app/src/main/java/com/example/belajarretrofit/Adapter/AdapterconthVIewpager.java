package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterconthVIewpager extends RecyclerView.Adapter<AdapterconthVIewpager.Myholder> {
    Context context;
    private List<String> items;

    public AdapterconthVIewpager(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @NotNull
    @Override
    public AdapterconthVIewpager.Myholder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contohimg, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull AdapterconthVIewpager.Myholder holder, int position) {
        String itemText = items.get(position);

        holder.contohBG.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_dark));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {

        RelativeLayout contohBG;

        public Myholder(@NotNull View itemView) {
            super(itemView);
            contohBG = itemView.findViewById(R.id.contohBG);
        }
    }
}
