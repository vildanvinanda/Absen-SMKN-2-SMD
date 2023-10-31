package com.example.belajarretrofit.View;

import android.graphics.Bitmap;

import java.io.File;
import java.time.LocalDate;

public interface ViewQRcode {
    void viewQrImage(Bitmap bitmap, LocalDate selectedDate);

    void Error(String localizedMessage);

    void showSuccessMessage();

    void updateGallery(File imageFile);

    void showErrorMessage();
}
