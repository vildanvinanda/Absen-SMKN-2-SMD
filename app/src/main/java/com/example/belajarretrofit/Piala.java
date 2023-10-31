package com.example.belajarretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.belajarretrofit.Activity.ASuperUser.TambahPrestasi;
import com.example.belajarretrofit.Adapter.AdapterGaleri;
import com.example.belajarretrofit.Adapter.AdapterPiala;
import com.example.belajarretrofit.Model.Piala.ModelPiala;
import com.example.belajarretrofit.Presenter.PialaPresenter;
import com.example.belajarretrofit.View.PialaView;
import com.example.belajarretrofit.databinding.ActivityPialaBinding;

import java.util.List;

public class Piala extends AppCompatActivity implements PialaView{

    private AdapterPiala adapterPiala;
    private PialaPresenter presenter;
    private ActivityPialaBinding binding;
    SessionManager sessionManager;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPialaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new ProgressDialog(getApplicationContext());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pengambilan data");
        dialog.setCanceledOnTouchOutside(false);

        presenter = new PialaPresenter(this);
        presenter.getData();

        sessionManager = new SessionManager(this);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        if(type.equals("super user")){
            binding.btnTambahPiala.setVisibility(View.VISIBLE);
            binding.btnTambahPiala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Piala.this, TambahPrestasi.class);
                    startActivity(intent);
                }
            });
        } else if(type.equals("admin")){
            binding.btnTambahPiala.setVisibility(View.VISIBLE);
            binding.btnTambahPiala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Piala.this, TambahPrestasi.class);
                    startActivity(intent);
                }
            });
        } else {
            binding.btnTambahPiala.setVisibility(View.GONE);
        }

        AllButton();

    }

    private void AllButton() {
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onProgress() {

    }

    @Override
    public void doneProgress() {

    }

    @Override
    public void onError(String localizedMessage) {

    }

    @Override
    public void onSuccess(List<ModelPiala> piala) {
        binding.recPiala.setAdapter(new AdapterPiala(getApplicationContext(),piala));
        binding.recPiala.setLayoutManager(new GridLayoutManager(this,2));
        binding.recPiala.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }
}