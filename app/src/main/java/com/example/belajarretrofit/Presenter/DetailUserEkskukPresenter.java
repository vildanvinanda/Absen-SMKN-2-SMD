package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.DafEkskul.ResponseDelete;
import com.example.belajarretrofit.View.DetailUserEkskulInterface;
import com.example.belajarretrofit.View.DetailUserInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserEkskukPresenter {

    DetailUserEkskulInterface view;

    public DetailUserEkskukPresenter(DetailUserEkskulInterface view) {
        this.view = view;
    }

    public void deleteItem(String namaE, String uid) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ResponseDelete> call = apiInterface.deleteUserInEkskul(namaE,uid);
        call.enqueue(new Callback<ResponseDelete>() {
            @Override
            public void onResponse(Call<ResponseDelete> call, Response<ResponseDelete> response) {
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccsesDelete(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseDelete> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void addJabatan(String namaE, String uid, String jabatan) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ResponseDelete> call = apiInterface.updateStatusUserEkskul(namaE, uid, jabatan);
        call.enqueue(new Callback<ResponseDelete>() {
            @Override
            public void onResponse(Call<ResponseDelete> call, Response<ResponseDelete> response) {
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccses(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseDelete> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
