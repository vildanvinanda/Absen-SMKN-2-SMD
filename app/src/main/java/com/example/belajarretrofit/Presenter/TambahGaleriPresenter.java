package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Galeri.ModelTambahGaleri;
import com.example.belajarretrofit.View.TambahGaleriInterface;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahGaleriPresenter {

    TambahGaleriInterface view;

    public TambahGaleriPresenter(TambahGaleriInterface view) {
        this.view = view;
    }


    public void sendTambahGaleri(RequestBody judul, RequestBody deskripsi, RequestBody tanggal, MultipartBody.Part img) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelTambahGaleri> call = apiInterface.sendDataGaleri("", judul, deskripsi, tanggal, img);
        call.enqueue(new Callback<ModelTambahGaleri>() {
            @Override
            public void onResponse(Call<ModelTambahGaleri> call, Response<ModelTambahGaleri> response) {
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccess(response.body().getMessage());
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ModelTambahGaleri> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
