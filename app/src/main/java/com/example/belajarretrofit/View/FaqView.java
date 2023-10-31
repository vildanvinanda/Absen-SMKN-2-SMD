package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.ProfilSetting.ModelFAQResponse;

import java.util.List;

public interface FaqView {

    void onSuccess(List<ModelFAQResponse> list);
    void onFailure();
    void onError(String localizedMessage);
    void onProgress();
    void doneProgress();
}
