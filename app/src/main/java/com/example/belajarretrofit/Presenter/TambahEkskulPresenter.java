package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Ekskul.ModelCreateEkskul;
import com.example.belajarretrofit.Model.Galeri.ModelTambahGaleri;
import com.example.belajarretrofit.View.TambahEkskulInterface;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahEkskulPresenter {
    TambahEkskulInterface view;

    public TambahEkskulPresenter(TambahEkskulInterface view) {
        this.view = view;
    }

    public void sendTambahEkskul(String namaEks, String namaES, RequestBody namaEkskul, RequestBody deskripsi, RequestBody pembina, MultipartBody.Part img) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelCreateEkskul> call = apiInterface.createEkskul("",namaEkskul, deskripsi, img);
        call.enqueue(new Callback<ModelCreateEkskul>() {
            @Override
            public void onResponse(Call<ModelCreateEkskul> call, Response<ModelCreateEkskul> response) {
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccess(response.body().getMessage());

                    // Logika untuk membuat tabel
                    createNewTable(namaEks, namaES);
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ModelCreateEkskul> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    private void createNewTable(String namaEks, String namaES) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelCreateEkskul> call = apiInterface.sendTabelEkskul(namaEks, namaES);
        call.enqueue(new Callback<ModelCreateEkskul>() {
            @Override
            public void onResponse(Call<ModelCreateEkskul> call, Response<ModelCreateEkskul> response) {
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccess(response.body().getMessage());

                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ModelCreateEkskul> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
