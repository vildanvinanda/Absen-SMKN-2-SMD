package com.example.belajarretrofit.View;

public interface DetailAllUserInterface {
    void onProgress();

    void doneProgress();

    void onError(String localizedMessage);

    void onSuccses(String message);
}
