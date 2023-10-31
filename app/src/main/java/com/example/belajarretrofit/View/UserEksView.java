package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.SessionManager;

import java.util.List;

public interface UserEksView {
    void onSuccess(List<ModelUser> kolom1);
    void onError(String localizedMessage);

    void onResponsePP(String responseBody, String uid);

    void onErrorPP(String localizedMessage);

    void doneProgressUpdatePP();

    void onProgressUpdatePP();

//    void onSuccessImg(List<ModelGetUser> img);

    void onSuccessImg(String imageUrl, SessionManager sessionManager);

    void Failure(String message);

//    void getEKskul(String kolom1, String kolom2, String uid);
//
//
//    void onErrorStatus(String localizedMessage);
//
//    void Test(String message);
//
//    void getStatusEk1(String statusEk);
}
