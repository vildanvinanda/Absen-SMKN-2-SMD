package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.jadwal.JadwalModel;
import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.SessionManager;

import java.time.LocalDate;
import java.util.List;

public interface JadwalView {

    void onItemClick(int position, LocalDate date);

    void showProgress();
    void hideProgress();
    void onSuccsess(String message);
    void onFailure(String message);
    void onError(String localizedMessage);

    void onGetResult(List<JadwalModel> items);
}
