package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Galeri.ModelGaleri;
import com.example.belajarretrofit.Model.riwayat.ModelRiwayat;
import com.example.belajarretrofit.View.GaleriView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GaleriPresenter {

    GaleriView view;

    public GaleriPresenter(GaleriView view) {
        this.view = view;
    }


    public void setDataGaleri() {
        view.onProsess();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGaleri>> call = apiInterface.getGaleri();
        call.enqueue(new Callback<List<ModelGaleri>>() {
            @Override
            public void onResponse(Call<List<ModelGaleri>> call, Response<List<ModelGaleri>> response) {
                view.donePresess();
                if (response.isSuccessful()){
                    List<ModelGaleri> galeri = response.body();
                    view.onShowData(galeri);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGaleri>> call, Throwable t) {
                view.donePresess();
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
