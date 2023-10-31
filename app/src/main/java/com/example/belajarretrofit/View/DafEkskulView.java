package com.example.belajarretrofit.View;

public interface DafEkskulView {
    void onProgress();
    void doneProgress();
    void onSuccsess(String message);
    void onError(String localizedMessage);
    void onFailure(String message);
}
