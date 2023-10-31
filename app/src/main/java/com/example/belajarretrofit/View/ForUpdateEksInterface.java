package com.example.belajarretrofit.View;

public interface ForUpdateEksInterface {
    void showSuccese(String message);

    void showFailure(String message);

    void showError(String localizedMessage);

    void doneProgres();

    void onProgress();
}
