package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.itemClick.RecyclerViewItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HolderBergabung extends RecyclerView.ViewHolder {

    public TextView addnama,addnis, addkls;
    public ImageView img;

    public HolderBergabung(@NotNull View itemView) {
        super(itemView);

        addnama = (TextView) itemView.findViewById(R.id.addnama);
        addnis = (TextView) itemView.findViewById(R.id.addnis);
        addkls = (TextView) itemView.findViewById(R.id.addkls);
        img = (ImageView) itemView.findViewById(R.id.img);


    }
}
