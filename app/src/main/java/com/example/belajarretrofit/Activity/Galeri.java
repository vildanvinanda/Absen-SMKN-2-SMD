package com.example.belajarretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.belajarretrofit.Activity.ASuperUser.TambahGaleri;
import com.example.belajarretrofit.Adapter.AdapterEkskul;
import com.example.belajarretrofit.Adapter.AdapterGaleri;
import com.example.belajarretrofit.Adapter.AdapterRiwayat;
import com.example.belajarretrofit.Model.Galeri.ModelGaleri;
import com.example.belajarretrofit.Presenter.GaleriPresenter;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.GaleriView;
import com.example.belajarretrofit.databinding.ActivityGaleriBinding;

import java.util.List;

public class Galeri extends AppCompatActivity implements GaleriView {

    private ActivityGaleriBinding binding;
    AdapterGaleri adapterGaleri;
    ProgressDialog dialog;
    GaleriPresenter presenter;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGaleriBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dialog = new ProgressDialog(getApplicationContext());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        presenter = new GaleriPresenter(this);
        presenter.setDataGaleri();

        sessionManager = new SessionManager(this);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        if(type.equals("super user")){
            binding.btnTambahGaleri.setVisibility(View.VISIBLE);
            binding.btnTambahGaleri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Galeri.this, TambahGaleri.class);
                    startActivity(intent);
                }
            });
        } else {
            binding.btnTambahGaleri.setVisibility(View.GONE);
        }

    }

    @Override
    public void onProsess() {

    }

    @Override
    public void onError(String localizedMessage) {

    }

    @Override
    public void donePresess() {

    }

    @Override
    public void onShowData(List<ModelGaleri> galeri) {
        binding.recGaleri.setAdapter(new AdapterGaleri(getApplicationContext(),galeri));
        binding.recGaleri.setLayoutManager(new GridLayoutManager(this,2));
//        binding.recGaleri.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false));
    }
}