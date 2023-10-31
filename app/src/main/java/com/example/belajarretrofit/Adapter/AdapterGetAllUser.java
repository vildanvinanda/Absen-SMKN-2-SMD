package com.example.belajarretrofit.Adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.Admin.DetailUser;
import com.example.belajarretrofit.Holder.HolderEkskulUser;
import com.example.belajarretrofit.Holder.HolderUser;
import com.example.belajarretrofit.Model.User.ModelUserPlusJML;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterGetAllUser extends RecyclerView.Adapter<HolderUser>{

    Context context;
    List<ModelUserPlusJML> modelUserPlusJMLS;

    public static final String EXTRA_UID = "uid";
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_NIS = "nis";
    public static final String EXTRA_IMG = "img";
    public static final String EXTRA_ALAMAT = "alamat";
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_KLS = "kelas";
    public static final String EXTRA_JK = "jk";
    public static final String EXTRA_NOHP= "nohp";
    public static final String EXTRA_TYPEUSER= "type";

    public AdapterGetAllUser(Context context, List<ModelUserPlusJML> modelUserPlusJMLS) {
        this.context = context;
        this.modelUserPlusJMLS = modelUserPlusJMLS;
    }

    @NotNull
    @Override
    public HolderUser onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderUser(LayoutInflater.from(context).inflate(R.layout.item_user,parent, false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderUser holder, int position) {
        ModelUserPlusJML model = modelUserPlusJMLS.get(position);

        holder.eddnama.setText(model.getNama());
        holder.eddkls.setText(model.getKelas());
        holder.eddnis.setText(model.getNis());

        Glide.with(holder.addimguser).load(model.getImg_user()).centerCrop().into(holder.addimguser);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailUser.class);
                intent.putExtra(EXTRA_NAMA, model.getNama());
                intent.putExtra(EXTRA_UID, model.getUid());
                intent.putExtra(EXTRA_NIS, model.getNis());
                intent.putExtra(EXTRA_IMG, model.getImg_user());
                intent.putExtra(EXTRA_JK, model.getJk());
                intent.putExtra(EXTRA_ALAMAT, model.getAlamat());
                intent.putExtra(EXTRA_EMAIL, model.getEmail());
                intent.putExtra(EXTRA_KLS, model.getKelas());
                intent.putExtra(EXTRA_NOHP, model.getNo_hp());
                intent.putExtra(EXTRA_TYPEUSER, model.getType_user());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
//                Toast.makeText(context, model.getNama(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelUserPlusJMLS.size();
    }
}
