package com.example.belajarretrofit.Adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.Holder.HolderEkskulUser;
import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterEkUser extends RecyclerView.Adapter<HolderEkskulUser> {

    Context context;
    List<ModelUser> modelUsers;

    public AdapterEkUser(Context context, List<ModelUser> modelUsers) {
        this.context = context;
        this.modelUsers = modelUsers;
    }

    @NotNull
    @Override
    public HolderEkskulUser onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderEkskulUser(LayoutInflater.from(context).inflate(R.layout.item_ekskul,parent, false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderEkskulUser holder, int position) {
        ModelUser model = modelUsers.get(position);
//        holder.txtEks.setText(model.getKolom1());

        String cek1 = model.getKolom1().toString();
        String cek2 = model.getKolom2().toString();

        if(cek1.isEmpty()){
            holder.card.setVisibility(View.GONE);
        } else if (cek1 != null){
            holder.card.setVisibility(View.VISIBLE);
            holder.txtEks.setText(model.getKolom1());
        }

        if (cek2.isEmpty()){
            holder.card2.setVisibility(View.GONE);
        }else {
            holder.card2.setVisibility(View.VISIBLE);
            holder.txtEks2.setText(model.getKolom2());
        }

    }

    @Override
    public int getItemCount() {
        return modelUsers.size();
    }
}
