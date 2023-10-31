package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.ProfilSetting.UpdateProfilResponse;
import com.example.belajarretrofit.Model.User.ModelPP;
import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.UserEksView;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserEksPresenter {
    UserEksView view;
    private static final String TAG = "UserEksPresenter";
    public UserEksPresenter(UserEksView view) {
        this.view = view;
    }


    public void onGetEkskul(String uid) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelUser>> call = apiInterface.getEkUser(uid);
        call.enqueue(new Callback<List<ModelUser>>() {
            @Override
            public void onResponse(Call<List<ModelUser>> call, Response<List<ModelUser>> response) {
                if (response.isSuccessful()){
                    List<ModelUser> kolom1 = response.body();
                    view.onSuccess(kolom1);
                }
            }

            @Override
            public void onFailure(Call<List<ModelUser>> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void updatePP(MultipartBody.Part body, RequestBody userId, String uid_user) {
        view.onProgressUpdatePP();
        ApiInterface apiService = ApiService.getClient().create(ApiInterface.class);
        Call<UpdateProfilResponse> call = apiService.uploadImage(body, userId);

        call.enqueue(new Callback<UpdateProfilResponse>() {
            @Override
            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
                if (response.isSuccessful()) {
                    view.doneProgressUpdatePP();
                    String responseBody = response.body().getMessage();
//                    String img = response.body().getLogindata().getImgUser();
//                    view.onResponsePP(responseBody);
//                    String responseBody = response.body().getMessage();
//                    String img = response.body().getLogindata().getImgUser();
                    view.onResponsePP(responseBody,uid_user);
                    loadImageFromServer(uid_user);

                } else {
                    view.doneProgressUpdatePP();
                }
                // Handle the server response here
            }

            @Override
            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
//                t.printStackTrace();
                view.doneProgressUpdatePP();
                view.onErrorPP(t.getLocalizedMessage());
            }
        });
    }

    SessionManager sessionManager;

    public void getImage(String uidd) {

        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelPP> call = apiInterface.getImage("100499996679340032");
        call.enqueue(new Callback<ModelPP>() {
            @Override
            public void onResponse(Call<ModelPP> call, Response<ModelPP> response) {
                String body = response.body().getImageUrl();
                view.onSuccessImg(body, sessionManager);
            }

            @Override
            public void onFailure(Call<ModelPP> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });
    }

//    public void updatePP(String imageBase64, String uid) {
//
//        ApiInterface apiService = ApiService.getClient().create(ApiInterface.class);
//        Call<UpdateProfilResponse> call = apiService.uploadImage(uid,imageBase64);
//
//        call.enqueue(new Callback<UpdateProfilResponse>() {
//            @Override
//            public void onResponse(Call<UpdateProfilResponse> call, Response<UpdateProfilResponse> response) {
//                if (response.isSuccessful()) {
//                    view.doneProgressUpdatePP();
//                    String responseBody = response.body().getMessage();
////                    String img = response.body().getLogindata().getImgUser();
//                    view.onResponsePP(responseBody,uid);
////                    loadImageFromServer(uid);
//
//                } else {
//                    view.doneProgressUpdatePP();
//                }
//                // Handle the server response here
//            }
//
//            @Override
//            public void onFailure(Call<UpdateProfilResponse> call, Throwable t) {
////                t.printStackTrace();
//                view.doneProgressUpdatePP();
//                view.onErrorPP(t.getLocalizedMessage());
//            }
//        });
//    }

    public void loadImageFromServer(String uid) {
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelPP> call = apiInterface.getImage(uid);
        call.enqueue(new Callback<ModelPP>() {
            @Override
            public void onResponse(Call<ModelPP> call, Response<ModelPP> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Dapatkan URL gambar dari respons JSON
                    String imageUrl = response.body().getImageUrl();

                    // Tampilkan gambar di ImageView menggunakan Glide atau perpustakaan lainnya
                    view.onSuccessImg(imageUrl, sessionManager);
                } else {
                    // Handle jika ada kesalahan dalam respons
//                    String responFailure = response.message();
//                    view.Failure(responFailure);
                }
            }

            @Override
            public void onFailure(Call<ModelPP> call, Throwable t) {

            }
        });
    }

//    public void onGetEkskul2(String uid) {
//        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
//        Call<ModelEkUser> call = apiInterface.getEkUser2(uid);
//       call.enqueue(new Callback<ModelEkUser>() {
//           @Override
//           public void onResponse(Call<ModelEkUser> call, Response<ModelEkUser> response) {
//               if(response.isSuccessful()){
//                   String kolom1 = response.body().getEksUser().getKolom1();
//                   String kolom2 = response.body().getEksUser().getKolom2();
//                   String uid = response.body().getEksUser().getUid();
//                   view.getEKskul(kolom1, kolom2, uid);
//               }
//           }
//
//           @Override
//           public void onFailure(Call<ModelEkUser> call, Throwable t) {
//
//           }
//       });
//    }
//
//    public void onGetStatus(String uid, String kata_kunci) {
//        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
//        Call<ModelStatusEkUser> call = apiInterface.getEkStatus1(kata_kunci, uid);
//        call.enqueue(new Callback<ModelStatusEkUser>() {
//            @Override
//            public void onResponse(Call<ModelStatusEkUser> call, Response<ModelStatusEkUser> response) {
//                if (response.isSuccessful()) {
//                    String statusEk = response.body().getStatus();
//                    // Lakukan sesuatu dengan data yang diterima dari server
//                    view.getStatusEk1(statusEk);
//                } else {
//                    // Penanganan kesalahan jika permintaan tidak berhasil
//
//                }
//            }
//            @Override
//            public void onFailure(Call<ModelStatusEkUser> call, Throwable t) {
//                view.onErrorStatus(t.getLocalizedMessage());
//            }
//        });
//    }
}
