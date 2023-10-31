package com.example.belajarretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Adapter.AdapterGaleri;
import com.example.belajarretrofit.databinding.ActivityDetailGaleriBinding;

public class DetailGaleri extends AppCompatActivity {

    private ActivityDetailGaleriBinding binding;
    AdapterGaleri adapterGaleri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailGaleriBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String judul = intent.getStringExtra(adapterGaleri.EXTRA_JUDUL);
        String img = intent.getStringExtra(adapterGaleri.EXTRA_IMG);
        String id = intent.getStringExtra(adapterGaleri.EXTRA_ID);
        String des = intent.getStringExtra(adapterGaleri.EXTRA_DES);
        String tgl = intent.getStringExtra(adapterGaleri.EXTRA_TGL);

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.txtjdl.setText(judul);
        binding.txtisi.setText(des);
        binding.txttgl.setText(tgl);
        Glide.with(binding.imgGaleri.getContext())
                .load(img)
                .centerCrop()
                .into(binding.imgGaleri);

    }
}