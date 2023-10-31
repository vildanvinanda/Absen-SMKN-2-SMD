package com.example.belajarretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.Activity.AUser.UserDashboardUser;
import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.Presenter.LoginPresenter;
import com.example.belajarretrofit.Register;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.LoginView;
import com.example.belajarretrofit.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity implements LoginView {

//    ILoginPresenter loginPresenter;
    private ActivityLoginBinding binding;
    String email, password;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //supaya this ini berfungsi kita harus meng implementasi viewnya
        loginPresenter = new LoginPresenter(this);

    }

    public void btnLogin(View view) {
        email =  binding.addemail.getText().toString();
        password =  binding.addpass.getText().toString();
//        loginPresenter.onLogin(email, password);
        loginPresenter.login(email,password);

    }

//    private void login(String email, String password) {
//
//        //ini berfungsi untuk mengambil getRetrofit dari presenter, dan buat create karena di interface juga ada create
//        //untuk mencek ada atau engganya data
////        loginPresenter = LoginPresenter.getClient().create(ILoginPresenter.class);
//        apiInterface = ApiService.getClient().create(ApiInterface.class);
//        //lalu ini kita hit atau send seperti di postman dengan cara call
////        Call<ModelLogin> loginCall = loginPresenter.loginResponse(email,password);
//        Call<ModelLogin> loginCall = apiInterface.loginResponse(email,password);
//        loginCall.enqueue(new Callback<ModelLogin>() {
//            @Override
//            public void onResponse(Call<ModelLogin> call, Response<ModelLogin> response) {
//                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
////
////                    // Ini untuk menyimpan sesi
//                    //dalam kurung ini  merupakan konteknya
//                    sessionManager = new SessionManager(Login.this);
//                    //data akan disimpa di LoginData
//                    Logindata loginData = response.body().getLogindata();
//                    //data yang telah diambil kita simpan di session
//                    sessionManager.createLoginSession(loginData);
//
//                    //Ini untuk pindah
//                    //ngambil data yang login. h
//                    Toast.makeText(Login.this, response.body().getLogindata().getKelas(), Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(Login.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelLogin> call, Throwable t) {
//                Toast.makeText(Login.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }

    public void btnForRegis(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Login.this, UserDashboardUser.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFaliure(String message) {
        Toast.makeText(Login.this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(Login.this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void forSessionss(SessionManager sessionManager, Logindata loginData) {
        // Ini untuk menyimpan sesi
        //dalam kurung ini  merupakan konteknya
        sessionManager = new SessionManager(Login.this);
        //data akan disimpa di LoginData
        //data yang telah diambil kita simpan di session
        sessionManager.createLoginSession(loginData);
    }
}