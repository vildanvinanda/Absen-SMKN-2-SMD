package com.example.belajarretrofit.Activity.AUser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.belajarretrofit.Presenter.FormPendaftaranPresenter;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.DafEkskulView;
import com.example.belajarretrofit.databinding.ActivityFormPendaftaranBinding;

public class FormPendaftaran extends AppCompatActivity implements DafEkskulView {

    private ActivityFormPendaftaranBinding binding;
    FormPendaftaranPresenter presenter;
    String namauser,nisuser,klsuser, nohpuser,alamatuser, jkuser;

    SessionManager sessionManager;
    ProgressDialog dialog;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormPendaftaranBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new FormPendaftaranPresenter(this);
        sessionManager = new SessionManager(FormPendaftaran.this);
        namauser = sessionManager.getUserDetail().get(SessionManager.NAMA);
        nisuser = sessionManager.getUserDetail().get(SessionManager.NIS);
        klsuser = sessionManager.getUserDetail().get(SessionManager.KELAS);
        nohpuser = sessionManager.getUserDetail().get(SessionManager.NO_HP);
        jkuser = sessionManager.getUserDetail().get(SessionManager.JK);
        alamatuser = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
        binding.addnama.setText(namauser);
        binding.addnis.setText(nisuser);
        binding.addkls.setText(klsuser);
        binding.addjk.setText(jkuser);
        binding.addnomor.setText(nohpuser);
        binding.addalamat.setText(alamatuser);
        binding.btnbergabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();

            }
        });

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

    }

    private void validasi() {
        sessionManager = new SessionManager(FormPendaftaran.this);
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String nama = binding.addnama.getText().toString();
        String nis = binding.addnis.getText().toString();
        String alamat = binding.addalamat.getText().toString();
        String nohp = binding.addnomor.getText().toString();
        String jk = binding.addjk.getText().toString();
        String kls = binding.addkls.getText().toString();
        String alasan = binding.addalasan.getText().toString();
        String ekskul = binding.addekstrakulikuler.getText().toString();

        if(TextUtils.isEmpty(nama)){
            binding.addnama.setError("Tolong Diisi");
            binding.addnama.requestFocus();
        } else if (TextUtils.isEmpty(nis)){
            binding.addnis.setError("Tolong Diisi");
            binding.addnis.requestFocus();
        }else if (nis.length() < 10){
            binding.addnis.setError("Wajib 10");
            binding.addnis.requestFocus();
        }else if (TextUtils.isEmpty(jk)){
            binding.addjk.setError("Tolong Diisi");
            binding.addjk.requestFocus();
        } else if (TextUtils.isEmpty(nohp)){
            binding.addnomor.setError("Tolong Diisi");
            binding.addnomor.requestFocus();
        } else if (nohp.length() < 12){
            binding.addnomor.setError("Wajib 12");
            binding.addnomor.requestFocus();
        } else if (TextUtils.isEmpty(alamat)){
            binding.addalamat.setError("Tolong Diisi");
            binding.addalamat.requestFocus();
        } else if (TextUtils.isEmpty(alasan)){
            binding.addalasan.setError("Tolong Diisi");
            binding.addalasan.requestFocus();
        } else if (TextUtils.isEmpty(kls)){
            binding.addkls.setError("Tolong Diisi");
            binding.addkls.requestFocus();
        } else if (TextUtils.isEmpty(ekskul)){
            binding.addekstrakulikuler.setError("Tolong Diisi");
            binding.addekstrakulikuler.requestFocus();
        } else {
            presenter.join(uid, nama, nis, jk, kls,alamat,alasan,ekskul,nohp);
        }
    }

    @Override
    public void onProgress() {
        dialog.show();
    }

    @Override
    public void doneProgress() {
        dialog.dismiss();
    }

    @Override
    public void onSuccsess(String message) {
        Toast.makeText(FormPendaftaran.this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FormPendaftaran.this, ListEksktrakulikuler.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(FormPendaftaran.this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(FormPendaftaran.this, message, Toast.LENGTH_SHORT).show();
    }

}