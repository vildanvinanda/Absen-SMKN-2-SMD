package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Ekskul.ModelEkskul;
import com.example.belajarretrofit.Model.Ekskul.ModelGetEkskul;
import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.Model.User.ModelUserPlusJML;
import com.example.belajarretrofit.View.ListUserInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserPresenter {

    ListUserInterface view;

    public ListUserPresenter(ListUserInterface view) {
        this.view = view;
    }

    public void getAllUser() {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelUserPlusJML>> call = apiInterface.getAllEkUser();
        call.enqueue(new Callback<List<ModelUserPlusJML>>() {
            @Override
            public void onResponse(Call<List<ModelUserPlusJML>> call, Response<List<ModelUserPlusJML>> response) {
                List<ModelUserPlusJML> modelGetUser = response.body();
                ModelUserPlusJML model = modelGetUser.get(0);
                // Ekstrak data yang ingin Anda tampilkan
                String jml = model.getJml();
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccess(response.body(), model.getJml());
                }else {
                    view.doneProgress();
                    view.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ModelUserPlusJML>> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());

            }
        });
    }

    public void getDataFilter(String toString) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelUserPlusJML>> call = apiInterface.getFilterAllUSer(toString);
        call.enqueue(new Callback<List<ModelUserPlusJML>>() {
            @Override
            public void onResponse(Call<List<ModelUserPlusJML>> call, Response<List<ModelUserPlusJML>> response) {
                List<ModelUserPlusJML> modelGetUser = response.body();
                ModelUserPlusJML model = modelGetUser.get(0);
                // Ekstrak data yang ingin Anda tampilkan
                String jml = model.getJml();
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccess(response.body(), model.getJml());
                }else {
                    view.doneProgress();
                    view.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ModelUserPlusJML>> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
