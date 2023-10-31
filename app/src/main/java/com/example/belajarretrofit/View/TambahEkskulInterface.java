package com.example.belajarretrofit.View;

public interface TambahEkskulInterface {
    void onProgress();

    void doneProgress();

    void onError(String localizedMessage);

    void onFailure(String message);

    void onSuccess(String message);
}
