package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.Ekskul.ModelEkskul;

import java.util.List;

public interface ListEkskulView {

    void showProgress();
    void hideProgress();
    void onSuccsess(String message);
    void onFailure(String message);

    void onError(String localizedMessage);

    void onGetResult(List<ModelEkskul> model);
}
