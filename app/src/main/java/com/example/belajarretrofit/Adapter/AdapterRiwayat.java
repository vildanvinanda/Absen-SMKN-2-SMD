package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.Holder.HolderRiwayat;
import com.example.belajarretrofit.Model.riwayat.ModelRiwayat;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterRiwayat extends RecyclerView.Adapter<HolderRiwayat> {

    Context context;
    List<ModelRiwayat> modelRiwayats;

    public AdapterRiwayat(Context context, List<ModelRiwayat> modelRiwayats) {
        this.context = context;
        this.modelRiwayats = modelRiwayats;
    }

    @NotNull
    @Override
    public HolderRiwayat onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderRiwayat(LayoutInflater.from(context).inflate(R.layout.item_riwayat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderRiwayat holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelRiwayats.size();
    }
}
