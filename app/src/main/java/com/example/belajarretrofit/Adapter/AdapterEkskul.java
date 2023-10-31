package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.DetailExtrakulikuler;
import com.example.belajarretrofit.Holder.HolderDataEkskul;
import com.example.belajarretrofit.Model.Ekskul.ModelEkskul;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterEkskul extends RecyclerView.Adapter<HolderDataEkskul> {

    public static final String EXTRA_ID= "id_ekskul";
    public static final String EXTRA_DESKRIPSI = "deskripsi";
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_IMG = "img";
    public static final String EXTRA_KETUA = "ketua";
    public static final String EXTRA_SEKRETARIS = "sekretaris";
    public static final String EXTRA_WAKIL = "wakil";
    public static final String EXTRA_BENDAHARA = "bendahara";
    public static final String EXTRA_JML = "jml_anggota";

    Context context;
    List<ModelEkskul> modelEkskuls;


    public AdapterEkskul(Context context, List<ModelEkskul> modelEkskuls) {
        this.context = context;
        this.modelEkskuls = modelEkskuls;
    }

    @NotNull
    @Override
    public HolderDataEkskul onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderDataEkskul(LayoutInflater.from(context).inflate(R.layout.item_eksktrakulikuler, parent,false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderDataEkskul holder, int position) {

        ModelEkskul model = modelEkskuls.get(position);
//        holder.img2.setImageResource(modelEkskuls.get(position).getImg());
        Glide.with(holder.img2.getContext())
                .load(model.getImg())
                .centerCrop()
                .into(holder.img2);
        holder.txtjdl2.setText(model.getNama());
        holder.txtisi2.setText(model.getDeskripsi());
//        holder.txttotal2.setText(modelEkskuls.get(position).getTo);

        String jdl = holder.txtjdl2.getText().toString();
//        String isi = holder.txtisi2.getText().toString();
        String total = holder.txttotal2.getText().toString();
        String namaEkskul = model.getNama();



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailExtrakulikuler.class);
                intent.putExtra(EXTRA_ID, model.getId_ekskul());
                intent.putExtra(EXTRA_NAMA, model.getNama());
                intent.putExtra(EXTRA_DESKRIPSI, model.getDeskripsi());
                intent.putExtra(EXTRA_IMG, model.getImg());
                intent.putExtra(EXTRA_KETUA, model.getKetua());
                intent.putExtra(EXTRA_WAKIL, model.getWakil());
                intent.putExtra(EXTRA_SEKRETARIS, model.getSekretaris());
                intent.putExtra(EXTRA_BENDAHARA, model.getBendahara());
                intent.putExtra(EXTRA_JML, model.getJml_anggota());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelEkskuls.size();
    }
}
