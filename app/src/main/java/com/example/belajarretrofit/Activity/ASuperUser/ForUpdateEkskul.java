package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.AUser.ListEksktrakulikuler;
import com.example.belajarretrofit.Activity.Galeri;
import com.example.belajarretrofit.DetailExtrakulikuler;
import com.example.belajarretrofit.Presenter.ForUpdateEkskulPresenter;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.ForUpdateEksInterface;
import com.example.belajarretrofit.databinding.ActivityForUpdateEkskulBinding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ForUpdateEkskul extends AppCompatActivity implements ForUpdateEksInterface {

    private ActivityForUpdateEkskulBinding binding;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int PICK_IMAGE_REQUEST = 1;
    ProgressDialog dialog;
    Bitmap bitmap;
    RequestBody id_ekskuk,nama, deskripsi;
//    MultipartBody.Part img = null;

    String encodedImages;
    ForUpdateEkskulPresenter presenter;
    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForUpdateEkskulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ForUpdateEkskulPresenter(this);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        Intent intent = getIntent();
        String namaeks = intent.getStringExtra(DetailExtrakulikuler.EXTRA_NAME);
        String imgeks = intent.getStringExtra(DetailExtrakulikuler.EXTRA_IMG);
        String deseks = intent.getStringExtra(DetailExtrakulikuler.EXTRA_DES);
        String id = intent.getStringExtra(DetailExtrakulikuler.EXTRA_IDEKS);

        binding.adddes.setText(deseks);
        binding.addnamaeks.setText(namaeks);
        Glide.with(getApplicationContext()).load(imgeks).centerCrop().into(binding.img);

        binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalery();
            }
        });

        binding.btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });
    }

    private void uploadData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra(DetailExtrakulikuler.EXTRA_IDEKS);
        String name = binding.addnamaeks.getText().toString();
        String des = binding.adddes.getText().toString();

        RequestBody nama = RequestBody.create(MediaType.parse("text/plain"), name);
        RequestBody id_ekskul = RequestBody.create(MediaType.parse("text/plain"), id);
        RequestBody deskripsi = RequestBody.create(MediaType.parse("text/plain"), des);


//        MultipartBody.Part img = prepareImageFileForUpload(selectedImageUri);

        if(TextUtils.isEmpty(des)){
            binding.adddes.setError("Tidak Boleh Kosong!");
            binding.adddes.requestFocus();
        } else if (TextUtils.isEmpty(name)){
            binding.addnamaeks.setError("Tidak Boleh Kosong!");
            binding.addnamaeks.requestFocus();
        } else if (selectedImageUri != null) {
            MultipartBody.Part img = prepareImageFileForUpload(selectedImageUri);
            presenter.updateDataEks(id_ekskul, deskripsi, nama, img);
        } else if (selectedImageUri == null){
            Toast.makeText(this, "Maaf Gambar Belum Diubah", Toast.LENGTH_SHORT).show();
        }
    }

    private MultipartBody.Part prepareImageFileForUpload(Uri selectedImageUri) {
        // Mendapatkan file path dari URI gambar
        String imagePath = getRealPathFromURI(selectedImageUri);

        // Membuat File object dari path gambar
        File imageFile = new File(imagePath);

        // Membuat RequestBody dari File
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imageFile);

        // Membuat MultipartBody.Part untuk gambar

        return MultipartBody.Part.createFormData("img", imageFile.getName(), requestFile);
    }

    private void openGalery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(Intent.createChooser(intent, "Browse Image"),1);
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
//                    try {
//                        InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
//                        bitmap = BitmapFactory.decodeStream(inputStream);
////                        binding.img.setImageBitmap(bitmap);
//                        Glide.with(getApplicationContext()).load(bitmap).centerCrop().into(binding.img);
//                        uploadImage(selectedImageUri,id_ekskul);
////                        encodeBitmapImage(bitmap);
//
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }

                    // Konversi URI gambar ke base64
//                    String imageBase64 = getBase64FromUri(selectedImageUri);

//                    presenter.updatePP(imageBase64, uid);

                }
            } else if (requestCode == REQUEST_IMAGE_CAPTURE) {
                if (data != null) {
                    Uri capturedImageUri = data.getData();
//                    uploadImage(capturedImageUri, uid);
                }
            }
        }


    }

    //Fungsi getRealPathFromUri digunakan untuk mengambil path file sebenarnya dari URI gambar yang
    // dipilih dari galeri. Berikut adalah implementasi sederhana dari getRealPathFromUri:
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
    public void showSuccese(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ForUpdateEkskul.this, ListEksktrakulikuler.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doneProgres() {
        dialog.dismiss();
    }

    @Override
    public void onProgress() {
        dialog.show();
    }
}