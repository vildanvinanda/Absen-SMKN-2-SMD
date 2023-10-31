package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Ekskul.ModelUserKolom;
import com.example.belajarretrofit.Model.ModelAbsen.ModelGetAbsen;
import com.example.belajarretrofit.Model.ModelGetStatusUserEk;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.View.ViewAbsenInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAbsenPresenter {

    ViewAbsenInterface view;

    public ViewAbsenPresenter(ViewAbsenInterface view) {
        this.view = view;
    }

    public void getKolom(String uid) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelUserKolom> call = apiInterface.getUserStatus2(uid);
        call.enqueue(new Callback<ModelUserKolom>() {
            @Override
            public void onResponse(Call<ModelUserKolom> call, Response<ModelUserKolom> response) {
                if (response.isSuccessful()){
                    ModelUserKolom body = response.body();
                    String kolom1 = body.getKolom1();
                    String kolom2 = body.getKolom2();

//                    getStatusKolom1(kolom1, uid);
//                    getStatusKolom2(kolom2, uid);

                    view.onSuccessGetKolom(kolom1,kolom2, uid);
                }
            }

            @Override
            public void onFailure(Call<ModelUserKolom> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void getList(String kolom1, String uid2) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetStatusUserEk>> call = apiInterface.getStatusUserEk(kolom1,uid2);
        call.enqueue(new Callback<List<ModelGetStatusUserEk>>() {
            @Override
            public void onResponse(Call<List<ModelGetStatusUserEk>> call, Response<List<ModelGetStatusUserEk>> response) {

                if (response.isSuccessful()){
                    List<ModelGetStatusUserEk> body = response.body();
                    if (body != null && !body.isEmpty()) {
                        // Daftar tidak kosong, Anda dapat mengambil elemennya
                        ModelGetStatusUserEk model = body.get(0);
                        String type = model.getStatus();
                        view.onSuccessForGetDaf(body, type, kolom1);
                    } else {
                        // Daftar kosong, Anda dapat menangani ini sesuai kebutuhan Anda
                        view.onEmptyData();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetStatusUserEk>> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void getViewAbsen(String kolom1) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetAbsen>> call = apiInterface.getAbsenResponse(kolom1);
        call.enqueue(new Callback<List<ModelGetAbsen>>() {
            @Override
            public void onResponse(Call<List<ModelGetAbsen>> call, Response<List<ModelGetAbsen>> response) {

                if (response.isSuccessful()){
                    List<ModelGetAbsen> body = response.body();
                    if (body != null && !body.isEmpty()) {
                        // Daftar tidak kosong, Anda dapat mengambil elemennya
//                        ModelGetAbsen model = body.get(0);
//                        String type = model.getTgl();
                        view.onSuccessForGetAbsen(body, kolom1);
                    } else {
                        // Daftar kosong, Anda dapat menangani ini sesuai kebutuhan Anda
                        view.onEmptyData();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetAbsen>> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
