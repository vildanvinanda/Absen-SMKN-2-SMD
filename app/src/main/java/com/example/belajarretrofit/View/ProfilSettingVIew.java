package com.example.belajarretrofit.View;

import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.SessionManager;

public interface ProfilSettingVIew {

    void onError(String localizedMessage);

    void onProgress();

    void onFailure(String message);

    void doneProgress();

    void onPassSuccsess(String message);

    void onNamaSuccsess(SessionManager sessionManager, String message, String addname);

    void onNomorSuccsess(SessionManager sessionManager, String message, String addnomor);

    void onG1Succsess(SessionManager sessionManager, String message, String g1);

    void onG2Succsess(SessionManager sessionManager, String message, String g2);

    void onKelasSuccsess(SessionManager sessionManager, String message, String kls);

    void onAlamatSuccsess(SessionManager sessionManager, String message, String alamat);
}
