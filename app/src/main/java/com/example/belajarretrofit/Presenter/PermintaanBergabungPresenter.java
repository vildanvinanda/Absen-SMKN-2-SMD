package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.DafEkskul.ModelDafEkskul;
import com.example.belajarretrofit.Model.DafEkskul.ModelDaftarEks;
import com.example.belajarretrofit.Model.EkUser.ModelEksStatus;
import com.example.belajarretrofit.Model.Ekskul.ModelUserKolom;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.View.PermintaanBergabungInterface;
import com.example.belajarretrofit.View.UserEksView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PermintaanBergabungPresenter {
    PermintaanBergabungInterface view;
    public PermintaanBergabungPresenter(PermintaanBergabungInterface view) {
        this.view = view;
    }


    public void onGetEkskul(String uid) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelUserKolom> call = apiInterface.getUserStatus2(uid);
        call.enqueue(new Callback<ModelUserKolom>() {
            @Override
            public void onResponse(Call<ModelUserKolom> call, Response<ModelUserKolom> response) {
                if (response.isSuccessful()){
                    ModelUserKolom body = response.body();
                    String kolom1 = body.getKolom1();
                    String kolom2 = body.getKolom2();

//                    getStatusKolom1(kolom1, uid);
//                    getStatusKolom2(kolom2, uid);

                    view.onSuccessGetKolom(kolom1,kolom2, uid);
                }
            }

            @Override
            public void onFailure(Call<ModelUserKolom> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });
    }

//    private void getStatusKolom2(String kolom2, String uid) {
//        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
//        Call<ModelEksStatus> call = apiInterface.spesificEksResponese(kolom2,uid);
//        call.enqueue(new Callback<ModelEksStatus>() {
//            @Override
//            public void onResponse(Call<ModelEksStatus> call, Response<ModelEksStatus> response) {
//                if (response.isSuccessful()){
//                    ModelEksStatus body = response.body();
//                    String status = body.getStatus();
//                    view.onSuccess2(status,kolom2);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelEksStatus> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void getStatusKolom1(String kolom1, String uid) {
//        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
//        Call<ModelEksStatus> call = apiInterface.spesificEksResponese(kolom1,uid);
//        call.enqueue(new Callback<ModelEksStatus>() {
//            @Override
//            public void onResponse(Call<ModelEksStatus> call, Response<ModelEksStatus> response) {
//                if (response.isSuccessful()){
//                    ModelEksStatus body = response.body();
//                    String status = body.getStatus();
//                    view.onSuccess(status, kolom1);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelEksStatus> call, Throwable t) {
//
//            }
//        });
//    }

    public void getList(String kolom1) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelReq>> call = apiInterface.getDataDafEKskul(kolom1);
        call.enqueue(new Callback<List<ModelReq>>() {
            @Override
            public void onResponse(Call<List<ModelReq>> call, Response<List<ModelReq>> response) {
//                if (response.isSuccessful()){
//                    List<ModelReq> body = response.body();
//// Ambil objek pertama dari daftar (atau objek yang sesuai dengan kriteria Anda)
//                    ModelReq model = body.get(0);
//
//                    // Ekstrak data yang ingin Anda tampilkan
//                    String jml = model.getJml();
//                    view.onSuccessForGetDaf(body, jml);
//                }
                if (response.isSuccessful()){
                    List<ModelReq> body = response.body();
                    if (body != null && !body.isEmpty()) {
                        // Daftar tidak kosong, Anda dapat mengambil elemennya
                        ModelReq model = body.get(0);
                        String jml = model.getJml();
                        view.onSuccessForGetDaf(body, jml);
                    } else {
                        // Daftar kosong, Anda dapat menangani ini sesuai kebutuhan Anda
                        view.onEmptyData();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelReq>> call, Throwable t) {

            }
        });
    }

    public void getList2(String kolom2) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelReq>> call = apiInterface.getDataDafEKskul(kolom2);
        call.enqueue(new Callback<List<ModelReq>>() {
            @Override
            public void onResponse(Call<List<ModelReq>> call, Response<List<ModelReq>> response) {
//                if (response.isSuccessful()){
//                    List<ModelReq> body = response.body();
//// Ambil objek pertama dari daftar (atau objek yang sesuai dengan kriteria Anda)
//                    ModelReq model = body.get(0);
//
//                    // Ekstrak data yang ingin Anda tampilkan
//                    String jml = model.getJml();
//                    view.onSuccessForGetDaf(body, jml);
//                }
            }

            @Override
            public void onFailure(Call<List<ModelReq>> call, Throwable t) {

            }
        });
    }

    public void getDataFilter(String toString, String Daftar) {
        view.onProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelReq>> call = apiInterface.getFilterDafEks(toString,Daftar);
        call.enqueue(new Callback<List<ModelReq>>() {
            @Override
            public void onResponse(Call<List<ModelReq>> call, Response<List<ModelReq>> response) {

                if (response.isSuccessful()){
                    List<ModelReq> body = response.body();
                    if (body != null && !body.isEmpty()) {
                        // Daftar tidak kosong, Anda dapat mengambil elemennya
                        ModelReq model2 = body.get(0);
                        String jml = model2.getJml();
                        view.onSuccess(body, jml);
                    } else {
                        // Daftar kosong, Anda dapat menangani ini sesuai kebutuhan Anda
                        view.onEmptyData();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelReq>> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

}
