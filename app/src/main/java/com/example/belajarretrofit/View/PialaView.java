package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.Piala.ModelPiala;

import java.util.List;

public interface PialaView {

    void onProgress();
    void doneProgress();
    void onError(String localizedMessage);
    void onSuccess(List<ModelPiala> piala);
}
