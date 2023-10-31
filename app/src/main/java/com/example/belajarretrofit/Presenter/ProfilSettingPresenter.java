package com.example.belajarretrofit.Presenter;

import android.app.ProgressDialog;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;

import com.example.belajarretrofit.Model.ProfilSetting.UpdateProfilResponse;
import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.ProfilSettingVIew;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilSettingPresenter {

    ProfilSettingVIew view;
    SessionManager sessionManager;
    ProgressDialog dialog;

    public ProfilSettingPresenter(ProfilSettingVIew view) {
        this.view = view;
    }

    public void updatePassword(String uid, String oldPass, String newPass) {
//        view.testnih(uid, oldPass, newPass);
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiInterface.UbahPassResponse(uid, oldPass, newPass);
        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {

                UpdateProfilResponse updatePassResponse = response.body();
                if (response.isSuccessful()) {
                    if(updatePassResponse.getStatus().equals("true")){
                        view.doneProgress();
                        view.onPassSuccsess(response.body().getMessage());
                    }else {
                        view.doneProgress();
                        view.onFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    //Update For User

    public void updateName(String uid, String addname) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiInterface.UbahNamaResponse(uid,addname);
        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
                UpdateProfilResponse updatePassResponse = response.body();
                if (response.isSuccessful()) {
                    if(updatePassResponse.getStatus().equals("true")){
                        view.doneProgress();
                        view.onNamaSuccsess(sessionManager, response.body().getMessage(), addname);
                    }else {
                        view.doneProgress();
                        view.onFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void updateNomor(String uid, String addnomor) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiInterface.UbahNoHPResponse(uid,addnomor);
        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
                UpdateProfilResponse updatePassResponse = response.body();
                if (response.isSuccessful()) {
                    if(updatePassResponse.getStatus().equals("true")){
                        view.doneProgress();
                        view.onNomorSuccsess(sessionManager, response.body().getMessage(), addnomor);
                    }else {
                        view.doneProgress();
                        view.onFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void updateJKL(String uid, String g1) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiInterface.UbahJKResponse(uid,g1);
        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
                UpdateProfilResponse updatePassResponse = response.body();
                if (response.isSuccessful()) {
                    if(updatePassResponse.getStatus().equals("true")){
                        view.doneProgress();
                        view.onG1Succsess(sessionManager, response.body().getMessage(), g1);
                    }else {
                        view.doneProgress();
                        view.onFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void updateJKP(String uid, String g2) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiInterface.UbahJKResponse(uid,g2);
        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
                UpdateProfilResponse updatePassResponse = response.body();
                if (response.isSuccessful()) {
                    if(updatePassResponse.getStatus().equals("true")){
                        view.doneProgress();
                        view.onG2Succsess(sessionManager, response.body().getMessage(), g2);
                    }else {
                        view.doneProgress();
                        view.onFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void updateKelas(String uid, String kls) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiInterface.UbahKelasResponse(uid,kls);
        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
                UpdateProfilResponse updatePassResponse = response.body();
                if (response.isSuccessful()) {
                    if(updatePassResponse.getStatus().equals("true")){
                        view.doneProgress();
                        view.onKelasSuccsess(sessionManager, response.body().getMessage(), kls);
                    }else {
                        view.doneProgress();
                        view.onFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void updateAlamat(String uid, String alamat) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiInterface.UbahAlamatResponse(uid,alamat);
        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
                UpdateProfilResponse updatePassResponse = response.body();
                if (response.isSuccessful()) {
                    if(updatePassResponse.getStatus().equals("true")){
                        view.doneProgress();
                        view.onAlamatSuccsess(sessionManager, response.body().getMessage(), alamat);
                    }else {
                        view.doneProgress();
                        view.onFailure(response.body().getMessage());
                    }
                } else {
                    view.doneProgress();
                    view.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    //Update For Admin
}
