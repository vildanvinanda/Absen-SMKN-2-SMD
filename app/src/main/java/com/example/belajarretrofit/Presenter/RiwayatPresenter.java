package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.jadwal.JadwalModel;
import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
import com.example.belajarretrofit.Model.register.ModelRegister;
import com.example.belajarretrofit.Model.riwayat.ModelRiwayat;
import com.example.belajarretrofit.View.RiwayatView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatPresenter {

    RiwayatView view;

    public RiwayatPresenter(RiwayatView view) {
        this.view = view;
    }


    public void setDataRiwayat(String uid) {
        view.showProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelRiwayat>> call = apiInterface.getRiwayat(uid);
        call.enqueue(new Callback<List<ModelRiwayat>>() {
            @Override
            public void onResponse(Call<List<ModelRiwayat>> call, Response<List<ModelRiwayat>> response) {
                view.hideProgress();
                if (response.isSuccessful()){
                    List<ModelRiwayat> uid = response.body();
                    view.onGetResult(uid);
                }
            }

            @Override
            public void onFailure(Call<List<ModelRiwayat>> call, Throwable t) {
                view.hideProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
