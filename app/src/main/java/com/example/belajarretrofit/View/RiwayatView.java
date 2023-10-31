package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.riwayat.ModelRiwayat;

import java.util.List;

public interface RiwayatView {
    void showProgress();
    void hideProgress();
    void onSuccsess(String message);
    void onFailure(String message);
    void onError(String localizedMessage);

    void onGetResult(List<ModelRiwayat> uid);
}
