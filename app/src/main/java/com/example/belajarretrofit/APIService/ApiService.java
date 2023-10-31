package com.example.belajarretrofit.APIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    //mengkonfig API kita
//    public static final String SERVER_REGISTER_URL = "https://192.168.100.14/ServerBelajarRetrofit/";
    public static final String SERVER = "http://192.168.100.14/ServerBelajarRetrofit/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
