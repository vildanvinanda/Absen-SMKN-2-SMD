package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.User.ModelUserPlusJML;

import java.util.List;

public interface ListUserInterface {
    void onSuccess(List<ModelUserPlusJML> message, String jml);

    void onProgress();

    void doneProgress();

    void onFailure(String message);

    void onError(String localizedMessage);
}
