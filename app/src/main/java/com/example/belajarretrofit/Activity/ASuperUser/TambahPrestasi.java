package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.Galeri;
import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.DetailExtrakulikuler;
import com.example.belajarretrofit.Piala;
import com.example.belajarretrofit.Presenter.TambahPialaPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.TambahPialaInterface;
import com.example.belajarretrofit.databinding.ActivityTambahGaleriBinding;
import com.example.belajarretrofit.databinding.ActivityTambahPrestasiBinding;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class TambahPrestasi extends AppCompatActivity implements TambahPialaInterface {

    TambahPialaPresenter presenter;
    private ActivityTambahPrestasiBinding binding;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int PICK_IMAGE_REQUEST = 1;
    ProgressDialog dialog;
    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahPrestasiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses input data");
        dialog.setCanceledOnTouchOutside(false);

        presenter = new TambahPialaPresenter(this);
        AllButton();


    }

    private void AllButton() {
        binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalery();
            }
        });
        binding.btnBuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jdl = binding.addjdl.getText().toString();
                String des = binding.addket.getText().toString();
//                String tgl = CalendarUtils.selectedDate.toString();
// Contoh objek LocalDate
                LocalDate localDate = LocalDate.now(); // Gantilah ini dengan LocalDate yang sesuai

// Format LocalDate menjadi string
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateStr = localDate.format(formatter);

                RequestBody judul = RequestBody.create(MediaType.parse("text/plain"), jdl);
                RequestBody deskripsi = RequestBody.create(MediaType.parse("text/plain"), des);
                RequestBody tanggal = RequestBody.create(MediaType.parse("text/plain"), dateStr);

                if(TextUtils.isEmpty(des)){
                    binding.addket.setError("Tidak Boleh Kosong!");
                    binding.addket.requestFocus();
                } else if (TextUtils.isEmpty(jdl)){
                    binding.addjdl.setError("Tidak Boleh Kosong!");
                    binding.addjdl.requestFocus();
                } else if (selectedImageUri != null) {
                    MultipartBody.Part img = prepareImageFileForUpload(selectedImageUri);
                    presenter.sendTambahPiala(judul, deskripsi, tanggal, img);
                } else if (selectedImageUri == null){
                    Toast.makeText(TambahPrestasi.this, "Maaf Gambar Belum Diubah", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = getIntent();
        String id_ekskul = intent.getStringExtra(DetailExtrakulikuler.EXTRA_IDEKS);
        if (resultCode==RESULT_OK)
        {
            if(requestCode == PICK_IMAGE_REQUEST)
            {
                if (data != null) {
                    selectedImageUri = data.getData();
                    Glide.with(getApplicationContext()).load(selectedImageUri).centerCrop().into(binding.img);
                }
            } else if (requestCode == REQUEST_IMAGE_CAPTURE) {
                if (data != null) {
                    Uri capturedImageUri = data.getData();
                }
            }
        }


    }

    private MultipartBody.Part prepareImageFileForUpload(Uri selectedImageUri) {
        String imagePath = getRealPathFromURI(selectedImageUri);

        File fileImg = new File(imagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), fileImg);

        return MultipartBody.Part.createFormData("img", fileImg.getName(), requestFile);
    }

    private String getRealPathFromURI(Uri selectedImageUri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(selectedImageUri, projection, null, null, null);

        if (cursor == null){
            return selectedImageUri.getPath();
        }

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String path = cursor.getString(column_index);
        cursor.close();
        return path;
    }

    private void openGalery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
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
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TambahPrestasi.this, Piala.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }
}