package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.DafEkskul.ModelDafEkskul;
import com.example.belajarretrofit.View.DafEkskulView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormPendaftaranPresenter {

    DafEkskulView view ;

    public FormPendaftaranPresenter(DafEkskulView view) {
        this.view = view;
    }


    public void join(String uid, String nama, String nis, String jk, String kls, String alamat, String alasan, String ekskul, String nohp) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelDafEkskul> modelDafEkskulCall = apiInterface.ekskuDaflResponse("",uid,nama, nis, jk, kls, alamat, alasan, ekskul, nohp);
        modelDafEkskulCall.enqueue(new Callback<ModelDafEkskul>() {
            @Override
            public void onResponse(Call<ModelDafEkskul> call, Response<ModelDafEkskul> response) {

                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    view.doneProgress();
                    view.onSuccsess(response.body().getMessage());
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<ModelDafEkskul> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
