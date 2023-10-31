package com.example.belajarretrofit.View;

public interface TambahPialaInterface {
    void onProgress();

    void doneProgress();

    void onSuccess(String message);

    void onFailure(String message);

    void onError(String localizedMessage);
}
