package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.ModelAbsen.ModelGetAbsen;
import com.example.belajarretrofit.Model.ModelGetStatusUserEk;

import java.util.List;

public interface ViewAbsenInterface {
    void onError(String localizedMessage);

    void onSuccessGetKolom(String kolom1, String kolom2, String uid);

    void onSuccessForGetDaf(List<ModelGetStatusUserEk> body, String type, String kolom1);

    void onEmptyData();

    void onSuccessForGetAbsen(List<ModelGetAbsen> body, String kolom1);
}
