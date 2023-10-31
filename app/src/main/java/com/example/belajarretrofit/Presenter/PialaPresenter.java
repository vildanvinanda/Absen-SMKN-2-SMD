package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Piala.ModelPiala;
import com.example.belajarretrofit.Piala;
import com.example.belajarretrofit.View.PialaView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PialaPresenter {

    PialaView view;

    public PialaPresenter(PialaView view) {
        this.view = view;
    }

    public void getData(){

        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelPiala>> call = apiInterface.getPiala();
        call.enqueue(new Callback<List<ModelPiala>>() {
            @Override
            public void onResponse(Call<List<ModelPiala>> call, Response<List<ModelPiala>> response) {
                if (response.isSuccessful()){
                    view.doneProgress();
                    List<ModelPiala> piala = response.body();
                    view.onSuccess(piala);
                }
            }

            @Override
            public void onFailure(Call<List<ModelPiala>> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });

    }
}
