package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.SessionManager;

public interface LoginView {

    void onSuccess(String message);
    void onFaliure(String message);
    void onError(String localizedMessage);
    void forSessionss(SessionManager sessionManager, Logindata loginData);

}
