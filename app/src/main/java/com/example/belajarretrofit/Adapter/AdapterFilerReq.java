package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Holder.HolderBergabung;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterFilerReq extends RecyclerView.Adapter<HolderBergabung> {

    Context context;
    ModelReq modelQeqBaskets;


    public AdapterFilerReq(Context context, ModelReq modelQeqBaskets) {
        this.context = context;
        this.modelQeqBaskets = modelQeqBaskets;
    }

    @NotNull
    @Override
    public HolderBergabung onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderBergabung(LayoutInflater.from(context).inflate(R.layout.item_permintaan,parent,false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderBergabung holder, int position) {

//        Intent intent = new Intent(context, PermintaanBergabung.class);
//        intent.putExtra(EXTRA_JML, model.getJml());
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);


        Glide.with(holder.img).load(modelQeqBaskets.getImg_user()).centerCrop().into(holder.img);
        holder.addnama.setText(modelQeqBaskets.getNama());
        holder.addnis.setText(modelQeqBaskets.getNis());
        holder.addkls.setText(modelQeqBaskets.getKls());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
