package com.example.belajarretrofit.Presenter;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.View.ViewQRcode;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class GenerateQrcodePresenter {
    private MultiFormatWriter multi = new MultiFormatWriter();
    ViewQRcode view;

    public GenerateQrcodePresenter(ViewQRcode view) {
        this.view = view;
    }


    public void generateQR(String namaeks, LocalDate selectedDate, LocalTime time) {
        try {
            JSONObject jsonObject = new JSONObject();
            // Menambahkan properti "nama" dengan nilai String
            jsonObject.put("nama", namaeks);
            // Menambahkan properti "tanggal" dengan nilai LocalDate
//            LocalDate selectedDate = LocalDate.now();
            jsonObject.put("tanggal", selectedDate);
            String jsonString = jsonObject.toString();
//                String basketJson = "Basket";
//                String tanggal = "03-10-2023";
//                String jsonString = "{\"nama\":\"" + basketJson + "\",\"tanggal\":\"" + tanggal + "\"}";

//            String code = editCode.getText().toString();

            BitMatrix bitMatrix = multi.encode(jsonString, BarcodeFormat.QR_CODE, 300, 300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            view.viewQrImage(bitmap, selectedDate);
        } catch (WriterException | JSONException e){
//            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            view.Error(e.getLocalizedMessage());
        }
    }

    public void downloadQrImage(Bitmap imageBitmap, String namaeks, LocalDate selectedDate) {
        new AsyncTask<Bitmap, Void, File>() {
            @Override
            protected File doInBackground(Bitmap... bitmaps) {
                File imageFile = saveImageToGallery(bitmaps[0],namaeks,selectedDate);
                return imageFile;
            }

            @Override
            protected void onPostExecute(File imageFile) {
                if (imageFile != null) {
                    // Menampilkan pesan sukses setelah gambar disimpan
//                    "Gambar berhasil diunduh dan disimpan di galeri."
                    view.showSuccessMessage();
                    // Memindahkan gambar ke aplikasi pengelola galeri
                    view.updateGallery(imageFile);
                } else {
                    // Menampilkan pesan kesalahan jika gagal
//                    "Gagal mengunduh dan menyimpan gambar."
                    view.showErrorMessage();
                }
            }
        }.execute(imageBitmap);
    }

    private File saveImageToGallery(Bitmap bitmap, String namaeks, LocalDate selectedDate) {
        File imageFile = null;
        try {

            File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
            if (!storageDir.exists()){
                storageDir.mkdirs();
            }
            String fileName = namaeks+"_"+selectedDate+".jpg";
            imageFile = new File(storageDir, fileName);

            FileOutputStream fos = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }
}
