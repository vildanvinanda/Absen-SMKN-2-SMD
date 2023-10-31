package com.example.belajarretrofit.View;

public interface TambahGaleriInterface {

    void onProgress();

    void doneProgress();

    void onSuccess(String message);

    void onFailure(String message);

    void onError(String localizedMessage);
}
