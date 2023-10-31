package com.example.belajarretrofit.Presenter;


import android.util.Log;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.Model.login.ModelLogin;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    LoginView loginView;
    SessionManager sessionManager;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String email, String password) {

        //ini berfungsi untuk mengambil getRetrofit dari presenter, dan buat create karena di interface juga ada create
        //untuk mencek ada atau engganya data
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        //lalu ini kita hit atau send seperti di postman dengan cara call
        Call<ModelLogin> loginCall = apiInterface.loginResponse(email,password);
        loginCall.enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(Call<ModelLogin> call, Response<ModelLogin> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
//
////                    // Ini untuk menyimpan sesi
//                    //dalam kurung ini  merupakan konteknya
//                    sessionManager = new SessionManager(Login.this);
//                    //data akan disimpa di LoginData
                    Logindata loginData = response.body().getLogindata();

//                    //data yang telah diambil kita simpan di session
//                    sessionManager.createLoginSession(loginData);
                    loginView.forSessionss(sessionManager, loginData);

                    //Ini untuk pindah
                    //ngambil data yang login. h
                    loginView.onSuccess(response.body().getMessage());

                } else {
                    loginView.onFaliure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {
                loginView.onError(t.getLocalizedMessage());
            }
        });


    }
}
