package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.DetailExtrakulikuler;
import com.example.belajarretrofit.Presenter.GenerateQrcodePresenter;
import com.example.belajarretrofit.View.ViewQRcode;
import com.example.belajarretrofit.databinding.ActivityBuatAbsenBinding;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class BuatAbsen extends AppCompatActivity implements ViewQRcode {

    private ActivityBuatAbsenBinding binding;
    GenerateQrcodePresenter presenter;
    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuatAbsenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        time = LocalTime.now();
        presenter = new GenerateQrcodePresenter(this);
        Intent intent = getIntent();
        CalendarUtils.selectedDate = LocalDate.now();
        String namaeks = intent.getStringExtra(DetailExtrakulikuler.EXTRA_NAME);

        presenter.generateQR(namaeks, CalendarUtils.selectedDate,time);
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    @Override
    public void viewQrImage(Bitmap bitmap, LocalDate selectedDate) {
        Intent intent = getIntent();
        String namaeks = intent.getStringExtra(DetailExtrakulikuler.EXTRA_NAME);
        binding.namaEks.setText(namaeks);
        binding.tgl.setText(String.valueOf(selectedDate));
        binding.qrcode.setImageBitmap(bitmap);
        binding.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(BuatAbsen.this, new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                presenter.downloadQrImage(bitmap, namaeks, selectedDate);
            }
        });
    }

    @Override
    public void Error(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BuatAbsen.this,  "Gambar berhasil diunduh dan disimpan di galeri.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void updateGallery(File imageFile) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(imageFile);
        mediaScanIntent.setData(contentUri);
        sendBroadcast(mediaScanIntent);
    }

    @Override
    public void showErrorMessage() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BuatAbsen.this, "Gagal mengunduh dan menyimpan gambar.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}