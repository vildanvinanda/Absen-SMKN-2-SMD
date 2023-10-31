package com.example.belajarretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Adapter.AdapterPiala;
import com.example.belajarretrofit.databinding.ActivityDetailPialaBinding;

public class DetailPiala extends AppCompatActivity {
    private ActivityDetailPialaBinding binding;
    private AdapterPiala adapterPiala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailPialaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String judul = intent.getStringExtra(adapterPiala.EXTRA_JUDUL);
        String img = intent.getStringExtra(adapterPiala.EXTRA_IMG);
        String id = intent.getStringExtra(adapterPiala.EXTRA_ID);
        String des = intent.getStringExtra(adapterPiala.EXTRA_DES);
        String tgl = intent.getStringExtra(adapterPiala.EXTRA_TGL);

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.txtjdl.setText(judul);
        binding.txtisi.setText(des);
        binding.txttgl.setText(tgl);
        Glide.with(binding.imgPiala.getContext())
                .load(img)
                .centerCrop()
                .into(binding.imgPiala);

    }
}