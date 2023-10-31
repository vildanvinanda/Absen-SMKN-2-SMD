package com.example.belajarretrofit.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.ASuperUser.TambahGaleri;
import com.example.belajarretrofit.Activity.ASuperUser.TambahPrestasi;
import com.example.belajarretrofit.Activity.AUser.ListEksktrakulikuler;
import com.example.belajarretrofit.Activity.Galeri;
import com.example.belajarretrofit.DetailExtrakulikuler;
import com.example.belajarretrofit.Presenter.TambahEkskulPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.TambahEkskulInterface;
import com.example.belajarretrofit.databinding.ActivityTambahEkskulBinding;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class TambahEkskul extends AppCompatActivity implements TambahEkskulInterface {

    private ActivityTambahEkskulBinding binding;
    TambahEkskulPresenter presenter;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int PICK_IMAGE_REQUEST = 1;
    ProgressDialog dialog;
    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahEkskulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new TambahEkskulPresenter(this);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses input data");
        dialog.setCanceledOnTouchOutside(false);

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
                String nama = binding.addnama.getText().toString();
                String namaE = "ek_"+nama;
                String namaES = "daf_ek_"+nama;
                String des = binding.addket.getText().toString();
                String namaPembina = binding.addpembina.getText().toString();


                LocalDate localDate = LocalDate.now(); // Gantilah ini dengan LocalDate yang sesuai

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateStr = localDate.format(formatter);
                RequestBody NamaEkskul = RequestBody.create(MediaType.parse("text/plain"), nama);
                RequestBody deskripsi = RequestBody.create(MediaType.parse("text/plain"), des);
                RequestBody Pembina = RequestBody.create(MediaType.parse("text/plain"), namaPembina);
//                RequestBody NamaEks = RequestBody.create(MediaType.parse("text/plain"), namaE);
//                RequestBody NamaES = RequestBody.create(MediaType.parse("text/plain"), namaES);

//                RequestBody Ketua = RequestBody.create(MediaType.parse("text/plain"), namaKetua);
//                RequestBody Wakil = RequestBody.create(MediaType.parse("text/plain"), namaWakil);
//                RequestBody Sekretaris = RequestBody.create(MediaType.parse("text/plain"), namaSekretaris);
//                RequestBody Bendahara = RequestBody.create(MediaType.parse("text/plain"), namaBendahara);

                if(TextUtils.isEmpty(des)){
                    binding.addket.setError("Tidak Boleh Kosong!");
                    binding.addket.requestFocus();
                } else if (TextUtils.isEmpty(nama)){
                    binding.addnama.setError("Tidak Boleh Kosong!");
                    binding.addnama.requestFocus();
                } else if (TextUtils.isEmpty(namaPembina)){
                    binding.addpembina.setError("Tidak Boleh Kosong!");
                    binding.addpembina.requestFocus();
                }else if (selectedImageUri != null) {
                    MultipartBody.Part img = prepareImageFileForUpload(selectedImageUri);
                    presenter.sendTambahEkskul(namaE, namaES, NamaEkskul, deskripsi, Pembina, img);
                } else if (selectedImageUri == null){
                    Toast.makeText(TambahEkskul.this, "Maaf Gambar Belum Diubah", Toast.LENGTH_SHORT).show();
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

    private void openGalery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
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

    @Override
    public void onProgress() {
        dialog.show();
    }

    @Override
    public void doneProgress() {
        dialog.dismiss();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TambahEkskul.this, ListEksktrakulikuler.class);
        startActivity(intent);
        finish();
    }
}