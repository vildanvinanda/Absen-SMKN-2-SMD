package com.example.belajarretrofit.Presenter;

import android.widget.ListView;
import android.widget.Toast;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.EkUser.ModelEksStatus;
import com.example.belajarretrofit.Model.EkUser.ModelStatus;
import com.example.belajarretrofit.Model.Ekskul.ModelEkskul;
import com.example.belajarretrofit.Model.Ekskul.ModelSpesificEkskul;
import com.example.belajarretrofit.Model.riwayat.ModelRiwayat;
import com.example.belajarretrofit.View.ListEkskulView;
import com.example.belajarretrofit.View.SpesificEkskulInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListEkskulPresenter {

    ListEkskulView view;
    SpesificEkskulInterface viewsSpesific;

    public ListEkskulPresenter(ListEkskulView view) {
        this.view = view;
    }

    public ListEkskulPresenter(SpesificEkskulInterface viewsSpesific) {
        this.viewsSpesific = viewsSpesific;
    }

//    public ListEkskulPresenter(ListEkskulView view, SpesificEkskulInterface viewsSpesific) {
//        this.view = view;
//        this.viewsSpesific = viewsSpesific;
//    }

    public void getDataEkskul(){
        view.showProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelEkskul>> call = apiInterface.getEkskul();
        call.enqueue(new Callback<List<ModelEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelEkskul>> call, Response<List<ModelEkskul>> response) {
                view.hideProgress();
                if (response.isSuccessful()){
                    List<ModelEkskul> model = response.body();
                    view.onGetResult(model);
                }
            }

            @Override
            public void onFailure(Call<List<ModelEkskul>> call, Throwable t) {
                view.hideProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }


    public void getDataFilter(CharSequence keyword) {
        view.showProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelEkskul>> call = apiInterface.getFilterEkskul(keyword);
        call.enqueue(new Callback<List<ModelEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelEkskul>> call, Response<List<ModelEkskul>> response) {
                view.hideProgress();
                if (response.isSuccessful()){
                    List<ModelEkskul> model = response.body();
                    view.onGetResult(model);
                }
            }

            @Override
            public void onFailure(Call<List<ModelEkskul>> call, Throwable t) {
                view.hideProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void getSpesificEkskul(String nama, String uid) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelEksStatus> call = apiInterface.spesificEksResponese(nama,uid);
        call.enqueue(new Callback<ModelEksStatus>() {
            @Override
            public void onResponse(Call<ModelEksStatus> call, Response<ModelEksStatus> response) {
                ModelEksStatus model = response.body();
                String status = model.getStatus();
                if (response.isSuccessful()) {
                    viewsSpesific.result(status);
                } else {
                    String eror = "Data tidak ditemukan";
                    viewsSpesific.showError(eror);
                }
            }

            @Override
            public void onFailure(Call<ModelEksStatus> call, Throwable t) {
                viewsSpesific.showError(t.getMessage());
            }
        });
    }
}
