package com.example.belajarretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class TestGenerateQR extends AppCompatActivity {
    private EditText editCode;
    private Button btnGenerate;
    private ImageView imageQr;
    private MultiFormatWriter multi = new MultiFormatWriter();
    private String jsonData ="{\"tgl\" : \"2023-10-03\",\"ekskul\" : \"Basket\"}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_generate_qr);
        editCode = findViewById(R.id.edit_code);
        btnGenerate = findViewById(R.id.btn_generate);
        imageQr = findViewById(R.id.image_qr);



        btnGenerate.setOnClickListener(v -> {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("nama", new JsonPrimitive("Basket"));
                jsonObject.add("tanggal", new JsonPrimitive("2023-10-01"));
                String jsonString = jsonObject.toString();
//                String basketJson = "Basket";
//                String tanggal = "03-10-2023";
//                String jsonString = "{\"nama\":\"" + basketJson + "\",\"tanggal\":\"" + tanggal + "\"}";

                String code = editCode.getText().toString();

                BitMatrix bitMatrix = multi.encode(jsonString, BarcodeFormat.QR_CODE, 300, 300);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                imageQr.setImageBitmap(bitmap);
            } catch (WriterException e){
                Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}