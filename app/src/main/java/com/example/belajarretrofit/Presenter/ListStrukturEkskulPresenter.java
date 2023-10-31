package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Ekskul.ModelGetEkskul;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.View.ListStrukturInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListStrukturEkskulPresenter {
    ListStrukturInterface view;

    public ListStrukturEkskulPresenter(ListStrukturInterface view) {
        this.view = view;
    }

    public void getDataBasket(String basket) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListEkskul(basket);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
                ModelGetEkskul model = modelGetUser.get(0);
                // Ekstrak data yang ingin Anda tampilkan
                String jml = model.getJml();
                if (response.isSuccessful()){
                    view.showJmlBasket(jml);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }

    public void getDataPaskibra(String paskibra) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListEkskul("Paskibra");
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
                ModelGetEkskul model = modelGetUser.get(0);
                // Ekstrak data yang ingin Anda tampilkan
                String jml = model.getJml();
                if (response.isSuccessful()){
                    view.showJmlPaskibra(jml);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {

            }
        });
    }

    public void getDataVolley(String volley) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListEkskul(volley);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {

            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {

            }
        });
    }

    public void getDataBadminton(String badminton) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListEkskul(badminton);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {

            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {

            }
        });
    }

    public void getDataSepakdola(String sepakbola) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListEkskul(sepakbola);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {

            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {

            }
        });
    }

    public void getDataSilat(String silat) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListEkskul(silat);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {

            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {

            }
        });
    }
}
