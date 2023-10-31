package com.example.belajarretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.belajarretrofit.Activity.Login;
import com.example.belajarretrofit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //supaya tidak login lagi maka kita akan cek sesinya
    SessionManager sessionManager;
    private ActivityMainBinding binding;

    //kita tambhakan String untuk menyimpan datanya
    String nama, kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //ini adalah sebuah objek sesi
        //kita tambahkan kondisi
        sessionManager = new SessionManager(MainActivity.this);
        //kita ccek
        //kita gunakan !
        if (sessionManager.isLogin() == false){
            //kita membuat sebuah method
            moveToLogin();
        }


        //letakan data yang ada di hasmap ke textview
        nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        kelas = sessionManager.getUserDetail().get(SessionManager.KELAS);

        binding.nama.setText(nama);
        binding.kelas.setText(kelas);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLogout();
            }
        });

    }

    private void moveToLogout() {
        sessionManager.logoutSession();
        moveToLogin();
    }

    private void moveToLogin() {
        //berikan fungsi
        Intent intent = new Intent(MainActivity.this, Login.class);
        //gunakan setFlags untuk data data yang di dalam mann activity
        //menggunakan Flag_Activity_No_History berguna suaya data yang ada di maiin activity ini gk adak lagi
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}