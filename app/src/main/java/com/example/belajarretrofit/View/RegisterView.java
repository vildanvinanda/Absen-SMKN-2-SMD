package com.example.belajarretrofit.View;

public interface RegisterView {
    void showProgress();
    void hideProgress();
    void onSuccsess(String message);
    void onFailure(String message);
    void onError(String localizedMessage);
}
