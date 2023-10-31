package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.register.ModelRegister;
import com.example.belajarretrofit.View.RegisterView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {

    private RegisterView view;

    public RegisterPresenter(RegisterView view) {
        this.view = view;
    }



    public void CreateToServer(String nis, String email, String password, String nama, String kelas, String no_hp, String jk, String alamat) {
//        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        view.showProgress();
//        loginPresenter = RegisterPresenter.getClient().create(ILoginPresenter.class);
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelRegister> regisCall = apiInterface.registerResponse("",nis,email,password, nama, kelas, no_hp, jk, alamat,"user","");
//        Call<ModelRegister> loginCall = apiInterface.loginResponse(email,password);
        regisCall.enqueue(new Callback<ModelRegister>() {
            @Override
            public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

                    //Ini untuk pindah
                    //ngambil data yang login. h
                    view.hideProgress();
                    view.onSuccsess(response.body().getRegisterData().getNama());
//
                } else {
                    view.hideProgress();
                    view.onFailure(response.body().getMessage());
//                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelRegister> call, Throwable t) {
                view.hideProgress();
                view.onError(t.getLocalizedMessage());
//                Toast.makeText(Register.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
