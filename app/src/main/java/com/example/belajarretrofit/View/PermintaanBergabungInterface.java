package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;

import java.util.List;

public interface PermintaanBergabungInterface {
    void onSuccess(List<ModelReq> model, String jml);

    void onError(String localizedMessage);

    void onSuccess2(String status, String kolom2);

    void onSuccessForGetDaf(List<ModelReq> body, String jml);

    void onSuccessGetKolom(String kolom1, String kolom2, String uid);

    void onProgress();

    void doneProgress();

    void onEmptyData();
}
