package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.DetailGaleri;
import com.example.belajarretrofit.Holder.HolderDashboard;
import com.example.belajarretrofit.Model.Galeri.ModelGaleri;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterGaleri extends RecyclerView.Adapter<HolderDashboard> {

    Context context;
    List<ModelGaleri> modelGaleriList;

    public static final String EXTRA_ID= "id_galeri";
    public static final String EXTRA_DES = "des";
    public static final String EXTRA_JUDUL = "judul";
    public static final String EXTRA_IMG = "img";
    public static final String EXTRA_TGL = "tgl";

    public AdapterGaleri(Context context, List<ModelGaleri> modelGaleriList){
        this.context =  context;
        this.modelGaleriList = modelGaleriList;
    }

    @NotNull
    @Override
    public HolderDashboard onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderDashboard(LayoutInflater.from(context).inflate(R.layout.item_galeri, parent,false));

    }

    @Override
    public void onBindViewHolder(@NotNull HolderDashboard holder, int position) {
//        holder.img.setImageResource(modelGaleriList.get(position).getImage());
        ModelGaleri model = modelGaleriList.get(position);

        Glide.with(holder.img.getContext())
                .load(model.getImg())
                .centerCrop()
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailGaleri.class);
//                context.startActivity(intent);
                //BELUM DI SET
                Intent intent = new Intent(context, DetailGaleri.class);
                intent.putExtra(EXTRA_IMG, model.getImg());
                intent.putExtra(EXTRA_JUDUL, model.getJudul());
                intent.putExtra(EXTRA_TGL, model.getTgl());
                intent.putExtra(EXTRA_DES, model.getDes());
                intent.putExtra(EXTRA_ID, model.getId_galeri());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelGaleriList.size();
    }
}
