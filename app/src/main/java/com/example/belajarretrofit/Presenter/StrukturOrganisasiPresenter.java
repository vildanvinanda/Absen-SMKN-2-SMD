package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Ekskul.ModelGetEkskul;
import com.example.belajarretrofit.View.StrukturOrganisasiInterface;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StrukturOrganisasiPresenter {

    StrukturOrganisasiInterface view;

    public StrukturOrganisasiPresenter(StrukturOrganisasiInterface view) {
        this.view = view;
    }


    public void onGetUser(String namaE) {

    }

    public void onGetKetua(String namaE, String status) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListStatusEksUser(namaE, status);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
//                ModelGetEkskul model = modelGetUser.get(0);
//                // Ekstrak data yang ingin Anda tampilkan
//                String nama = model.getNama_user();
//                String status = model.getStatus();
                if (response.isSuccessful()){
                    view.showDataUser(modelGetUser);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }


    public void onGetWakil(String namaE, String status2) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListStatusEksUser(namaE, status2);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
//                ModelGetEkskul model = modelGetUser.get(0);
//                // Ekstrak data yang ingin Anda tampilkan
//                String nama = model.getNama_user();
//                String status = model.getStatus();
                if (response.isSuccessful()){
                    view.showDataUser2(modelGetUser);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }

    public void onGetSekretaris(String namaE, String status3) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListStatusEksUser(namaE, status3);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
//                ModelGetEkskul model = modelGetUser.get(0);
//                // Ekstrak data yang ingin Anda tampilkan
//                String nama = model.getNama_user();
//                String status = model.getStatus();
                if (response.isSuccessful()){
                    Collections.sort(modelGetUser, new Comparator<ModelGetEkskul>() {
                        @Override
                        public int compare(ModelGetEkskul item1, ModelGetEkskul item2) {
                            return item1.getNama_user().compareTo(item2.getNama_user());
                        }
                    });
                    view.showDataUser3(modelGetUser);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }

    public void onGetBendahara(String namaE, String status4) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListStatusEksUser(namaE, status4);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
//                ModelGetEkskul model = modelGetUser.get(0);
//                // Ekstrak data yang ingin Anda tampilkan
//                String nama = model.getNama_user();
//                String status = model.getStatus();
                if (response.isSuccessful()){
                    view.showDataUser4(modelGetUser);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }

    public void onGetAbsensi(String namaE, String status5) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListStatusEksUser(namaE, status5);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
//                ModelGetEkskul model = modelGetUser.get(0);
//                // Ekstrak data yang ingin Anda tampilkan
//                String nama = model.getNama_user();
//                String status = model.getStatus();
                if (response.isSuccessful()){
                    view.showDataUser5(modelGetUser);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }

    public void onGetAnggota(String namaE, String status6) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelGetEkskul>> call = apiInterface.getListStatusEksUser(namaE, status6);
        call.enqueue(new Callback<List<ModelGetEkskul>>() {
            @Override
            public void onResponse(Call<List<ModelGetEkskul>> call, Response<List<ModelGetEkskul>> response) {
                List<ModelGetEkskul> modelGetUser = response.body();
//                ModelGetEkskul model = modelGetUser.get(0);
//                // Ekstrak data yang ingin Anda tampilkan
//                String nama = model.getNama_user();
//                String status = model.getStatus();
                if (response.isSuccessful()){
                    view.showDataUser6(modelGetUser);
                }
            }

            @Override
            public void onFailure(Call<List<ModelGetEkskul>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }
}
