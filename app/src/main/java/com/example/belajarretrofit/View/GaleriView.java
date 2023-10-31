package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.Galeri.ModelGaleri;

import java.util.List;

public interface GaleriView {
    void onProsess();
    void onError(String localizedMessage);
    void donePresess();

    void onShowData(List<ModelGaleri> galeri);
}
