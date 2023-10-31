package com.example.belajarretrofit.Holder;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.security.AccessController;

public class HolderUser extends RecyclerView.ViewHolder {

    public TextView eddnama, eddkls, eddnis;
    public ImageView addimguser;

    public HolderUser(@NonNull @NotNull View itemView) {
        super(itemView);

        addimguser = (ImageView) itemView.findViewById(R.id.addimguser);
        eddnama = (TextView) itemView.findViewById(R.id.eddnama);
        eddnis = (TextView) itemView.findViewById(R.id.eddnis);
        eddkls = (TextView) itemView.findViewById(R.id.eddkls);

    }
}
