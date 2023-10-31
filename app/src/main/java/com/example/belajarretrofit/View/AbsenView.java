package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.ModelAbsen.ModelAbsenUser;

public interface AbsenView {
    void onProgressAbsen();
    void doneProgressAbsen();
    void onSuccsessAbsen(ModelAbsenUser message);
    void onFailureAbsen();
    void onErrorAbsen();
}
