package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Presenter.DetailUserPresenter;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.DetailUserInterface;
import com.example.belajarretrofit.databinding.ActivityDetailUserBinding;

public class DafDetailUser extends AppCompatActivity implements DetailUserInterface{

    SessionManager sessionManager;

    DetailUserPresenter presenter;
    private ActivityDetailUserBinding binding;
    ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String nama = intent.getStringExtra(PermintaanBergabung.EXTRA_NAMA);
        String nis = intent.getStringExtra(PermintaanBergabung.EXTRA_NIS);
        String kls = intent.getStringExtra(PermintaanBergabung.EXTRA_KLS);
        String alamat = intent.getStringExtra(PermintaanBergabung.EXTRA_ALAMAT);
        String alasan = intent.getStringExtra(PermintaanBergabung.EXTRA_ALASAN);
        String nohp = intent.getStringExtra(PermintaanBergabung.EXTRA_NOHP);
        String jk = intent.getStringExtra(PermintaanBergabung.EXTRA_JK);
        String img = intent.getStringExtra(PermintaanBergabung.EXTRA_IMG);
        String id = intent.getStringExtra(PermintaanBergabung.EXTRA_ID);
        String namaE = intent.getStringExtra(PermintaanBergabung.EXTRA_NAMA_EKSKUL);
        String uid = intent.getStringExtra(PermintaanBergabung.EXTRA_UID);

//        sessionManager = new SessionManager(this);
//        String getuid = sessionManager.getUserDetail().get(SessionManager.UID);


        binding.addNama.setText(nama);
        binding.addNis.setText(nis);
        binding.addKls.setText(kls);
        binding.addAlamat.setText(alamat);
        binding.addNohp.setText(nohp);
        binding.addJk.setText(jk);
        binding.addAlasan.setText(alasan);
        Glide.with(binding.addImg.getContext()).load(img).centerCrop().into(binding.addImg);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        presenter = new DetailUserPresenter(this);

        allButton(id,namaE,nama, nis, kls, jk, img, nohp, alamat, uid);

    }

    private void allButton(String id, String namaE, String nama, String nis, String kls, String jk, String img, String nohp, String alamat, String uid) {
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnTerima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sendUserToEkskul(id,namaE,nama, nis, kls, jk, img, nohp, alamat, uid);
            }
        });
        binding.btnTolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.deleteItem(id, namaE);
            }
        });
    }

    @Override
    public void onProgres() {
        dialog.show();
    }

    @Override
    public void doneProgress() {
        dialog.dismiss();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccses(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DafDetailUser.this, PermintaanBergabung.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void message() {
        Toast.makeText(this, "User Telah Ditambahkan", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    @Override
    public void onTasksCompleted() {
        dialog.dismiss();
        Toast.makeText(this, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DafDetailUser.this, PermintaanBergabung.class);
        startActivity(intent);
        finish();
    }

//    @Override
//    public void onSaveSuccses() {
//        // Semua tugas sudah selesai, tampilkan Toast
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                dialog.dismiss();
//                Toast.makeText(DetailUser.this, "", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}