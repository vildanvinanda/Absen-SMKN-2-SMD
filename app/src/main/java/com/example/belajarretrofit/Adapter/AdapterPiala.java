package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.DetailGaleri;
import com.example.belajarretrofit.Holder.HolderPiala;
import com.example.belajarretrofit.Model.Piala.ModelPiala;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterPiala extends RecyclerView.Adapter<HolderPiala> {

    Context context;
    List<ModelPiala> modelPialas;

    public static final String EXTRA_ID= "id_galeri";
    public static final String EXTRA_DES = "des";
    public static final String EXTRA_JUDUL = "judul";
    public static final String EXTRA_IMG = "img";
    public static final String EXTRA_TGL = "tgl";

    public AdapterPiala(Context context, List<ModelPiala> modelPialas) {
        this.context = context;
        this.modelPialas = modelPialas;
    }

    @NotNull
    @Override
    public HolderPiala onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderPiala(LayoutInflater.from(context).inflate(R.layout.item_piala, parent,false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderPiala holder, int position) {

        ModelPiala model = modelPialas.get(position);

        Glide.with(holder.imgp.getContext())
                .load(model.getImg())
                .centerCrop()
                .into(holder.imgp);

        holder.txtjdl.setText(model.getJudul());
        holder.txttgl.setText(model.getTgl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BELUM DI SET

                Intent intent = new Intent(context, DetailGaleri.class);
                intent.putExtra(EXTRA_IMG, model.getImg());
                intent.putExtra(EXTRA_JUDUL, model.getJudul());
                intent.putExtra(EXTRA_TGL, model.getTgl());
                intent.putExtra(EXTRA_DES, model.getDes());
                intent.putExtra(EXTRA_ID, model.getId_piala());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelPialas.size();
    }
}
