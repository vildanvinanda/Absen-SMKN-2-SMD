package com.example.belajarretrofit.Model.ProfilSetting;

import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.Model.login.Logindata;

public class UpdateProfilResponse {


        Logindata logindata;
        private String status;
        private String message;


        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

//        public UpdateProfilResponse(String status, String message) {
//            this.status = status;
//            this.message = message;
//        }


    public UpdateProfilResponse(Logindata logindata, String status, String message) {
        this.logindata = logindata;
        this.status = status;
        this.message = message;
    }

    public Logindata getLogindata() {
        return logindata;
    }

    public void setLogindata(Logindata logindata) {
        this.logindata = logindata;
    }
}
