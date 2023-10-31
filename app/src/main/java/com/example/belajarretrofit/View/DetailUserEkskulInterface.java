package com.example.belajarretrofit.View;

public interface DetailUserEkskulInterface {
    void onProgress();

    void doneProgress();

    void onSuccses(String message);

    void onError(String localizedMessage);

    void onSuccsesDelete(String message);
}
