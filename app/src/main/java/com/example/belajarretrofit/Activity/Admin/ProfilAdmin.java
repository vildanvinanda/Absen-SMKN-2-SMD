package com.example.belajarretrofit.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.belajarretrofit.Presenter.ProfilSettingPresenter;
import com.example.belajarretrofit.Presenter.UserPresenter;
import com.example.belajarretrofit.ProfilSetting;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.UserInterface;
import com.example.belajarretrofit.databinding.ActivityProfilAdminBinding;

public class ProfilAdmin extends AppCompatActivity implements UserInterface {

    private ActivityProfilAdminBinding binding;
    ProgressDialog dialog;
    UserPresenter presenter;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfilAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        presenter = new UserPresenter(this);
        sessionManager = new SessionManager(getApplicationContext());
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        String kls = sessionManager.getUserDetail().get(SessionManager.KELAS);
        String nis = sessionManager.getUserDetail().get(SessionManager.NIS);
        String typeuser = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);

      AllButton();



    }

    private void AllButton() {
        binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilAdmin.this, ProfilSetting.class);
                startActivity(intent);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}