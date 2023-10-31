package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Holder.HolderPiala;
import com.example.belajarretrofit.Holder.HolderViewAbsen;
import com.example.belajarretrofit.Model.ModelAbsen.ModelGetAbsen;
import com.example.belajarretrofit.Model.ModelGetStatusUserEk;
import com.example.belajarretrofit.Model.Piala.ModelPiala;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.itemClick.RecyclerAbsenClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterViewAbsen extends RecyclerView.Adapter<AdapterViewAbsen.HolderViewAbsen>{

    Context context;
    List<ModelGetAbsen> modelGetStatusUserEks;
    RecyclerAbsenClickListener listener;

    public AdapterViewAbsen(Context context, List<ModelGetAbsen> modelGetStatusUserEks, RecyclerAbsenClickListener listener) {
        this.context = context;
        this.modelGetStatusUserEks = modelGetStatusUserEks;
        this.listener = listener;
    }

    @NotNull
    @Override
    public HolderViewAbsen onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        return new HolderViewAbsen(LayoutInflater.from(context).inflate(R.layout.item_absen2, parent,false));
    }

    @Override
    public void onBindViewHolder(@NotNull AdapterViewAbsen.HolderViewAbsen holder, int position) {
        ModelGetAbsen model = modelGetStatusUserEks.get(position);

        holder.tgl.setText(model.getTgl());
        holder.nama.setText(model.getNama());


    }

//    @Override
//    public void onBindViewHolder(@NotNull HolderViewAbsen holder, int position) {
//        ModelGetAbsen model = modelGetStatusUserEks.get(position);
//
//        holder.tgl.setText(model.getTgl());
//
//    }

    @Override
    public int getItemCount() {
        return modelGetStatusUserEks.size();
    }

    public class HolderViewAbsen extends RecyclerView.ViewHolder {
        public TextView tgl, nama;
        public HolderViewAbsen(@NotNull View itemView) {
            super(itemView);
            tgl = itemView.findViewById(R.id.tgl);
            nama = itemView.findViewById(R.id.nama);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onItemClick(position, modelGetStatusUserEks);

                    }
                }
            });
        }
    }
}
