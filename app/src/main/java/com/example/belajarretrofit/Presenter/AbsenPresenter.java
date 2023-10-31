package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.ModelAbsen.ModelAbsenUser;
import com.example.belajarretrofit.View.AbsenView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsenPresenter {
    
    AbsenView view;

    public AbsenPresenter(AbsenView view) {
        this.view = view;
    }


    public void addAbsen(String uid, String nama, String tanggal, String namaUser, String kls, String nis) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelAbsenUser> call = apiInterface.addAbsenResponse("",nama,tanggal,uid,namaUser,nis,kls);
        call.enqueue(new Callback<ModelAbsenUser>() {
            @Override
            public void onResponse(Call<ModelAbsenUser> call, Response<ModelAbsenUser> response) {
                ModelAbsenUser model = response.body();
                if (response.isSuccessful()){
                    view.onSuccsessAbsen(model);
                }
            }

            @Override
            public void onFailure(Call<ModelAbsenUser> call, Throwable t) {

            }
        });
    }
}
