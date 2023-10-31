package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.UpdateEkskul.ModelUpdateEks;
import com.example.belajarretrofit.View.ForUpdateEksInterface;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForUpdateEkskulPresenter {

    ForUpdateEksInterface view;

    public ForUpdateEkskulPresenter(ForUpdateEksInterface view) {
        this.view = view;
    }

    public void updateDataEks(RequestBody id_ekskul, RequestBody deskripsi, RequestBody nama, MultipartBody.Part img) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

        Call<ModelUpdateEks> call = apiInterface.updateResponse(id_ekskul, nama, deskripsi, img);
        call.enqueue(new Callback<ModelUpdateEks>() {
            @Override
            public void onResponse(Call<ModelUpdateEks> call, Response<ModelUpdateEks> response) {

                if(response.isSuccessful()){
                    ModelUpdateEks modelUpdateEks = response.body();
                    if (modelUpdateEks != null && modelUpdateEks.getStatus().equals("true")){
                        view.doneProgres();
                        view.showSuccese(response.body().getMessage());
                    } else {
                        view.doneProgres();
                        view.showFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgres();
                    view.showFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ModelUpdateEks> call, Throwable t) {
                view.doneProgres();
                view.showError(t.getLocalizedMessage());
            }
        });
    }
}
