package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.Model.PermintaanBergabung.SendUkskulToUser;
import com.example.belajarretrofit.Model.PermintaanBergabung.SendUserEkskulModelResponse;
import com.example.belajarretrofit.View.DetailUserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserPresenter{

    DetailUserInterface view;

    public DetailUserPresenter(DetailUserInterface view) {
        this.view = view;
    }


    public void deleteItem(String id, String namaE) {
        view.onProgres();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelReq> call = apiInterface.deleteUser(namaE,id);
        call.enqueue(new Callback<ModelReq>() {
            @Override
            public void onResponse(Call<ModelReq> call, Response<ModelReq> response) {
                if (response.isSuccessful()){
                    view.doneProgress();
                    view.onSuccses(response.message());
                }
            }

            @Override
            public void onFailure(Call<ModelReq> call, Throwable t) {
                view.doneProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }

    public void sendUserToEkskul(String id, String namaE, String nama, String nis, String kls, String jk, String img, String nohp, String alamat, String uid){

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        view.onProgres();
        // Membuat daftar callable (tugas) yang akan dijalankan di thread terpisah
        List<Callable<Void>> tasks = new ArrayList<>();
        tasks.add(new UpdateTask(uid, namaE));
        tasks.add(new DeleteTask(namaE,id));
        tasks.add(new CreateTask(namaE, id, uid, nama, nis, jk, kls, alamat, nohp, img));

        // Jalankan semua tugas dan tunggu hingga selesai
        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tutup executorService setelah selesai
        executorService.shutdown();

        // Ketika semua tugas selesai, kirimkan pesan ke aktivitas
        view.onTasksCompleted();
    }

    private class UpdateTask implements Callable<Void> {

        private String namaE, uid;

        public UpdateTask(String uid, String namaE) {
            this.uid = uid;
            this.namaE = namaE;
        }

        @Override
        public Void call() throws Exception {
            ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
            Call<SendUkskulToUser> call2 = apiInterface.sendEkskulToColumnResponse(uid, namaE);
            call2.enqueue(new Callback<SendUkskulToUser>() {
                @Override
                public void onResponse(Call<SendUkskulToUser> call, Response<SendUkskulToUser> response) {
                    if (response.isSuccessful()){
                        view.doneProgress();
                    }
                }

                @Override
                public void onFailure(Call<SendUkskulToUser> call, Throwable t) {

                }
            });
            return null;
        }
    }

    private class DeleteTask implements Callable<Void> {
        private String namaE, id;

        public DeleteTask(String namaE, String id) {
            this.namaE = namaE;
            this.id = id;
        }

        @Override
        public Void call() throws Exception {
            ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
            Call<ModelReq> call3 = apiInterface.deleteUser(namaE, id);
            call3.enqueue(new Callback<ModelReq>() {
                @Override
                public void onResponse(Call<ModelReq> call, Response<ModelReq> response) {
                    if (response.isSuccessful()){
                        view.doneProgress();
                    }
                }

                @Override
                public void onFailure(Call<ModelReq> call, Throwable t) {

                }
            });
            return null;
        }
    }

    private class CreateTask implements Callable<Void> {

        String namaE, id, uid, nama, nis, jk, kls, alamat, nohp, img;

        public CreateTask(String namaE, String id, String uid, String nama, String nis, String jk, String kls, String alamat, String nohp, String img) {
            this.namaE = namaE;
            this.id = id;
            this.uid = uid;
            this.nama = nama;
            this.nis = nis;
            this.jk = jk;
            this.kls = kls;
            this.alamat = alamat;
            this.nohp = nohp;
            this.img = img;
        }

        @Override
        public Void call() throws Exception {
            // Implementasi update data di sini dengan menggunakan parameter-parameter yang telah diterima di konstruktor
            // Panggil metode API untuk update
            // Misalnya: apiInterface.updateData(id, namaE, nama, nis, kls, jk, img, nohp, alamat;

            ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
            Call<SendUserEkskulModelResponse> call = apiInterface.sendUserToEkskul(namaE, id, uid, nama, nis, jk, kls,alamat, nohp, img);
            call.enqueue(new Callback<SendUserEkskulModelResponse>() {
                @Override
                public void onResponse(Call<SendUserEkskulModelResponse> call, Response<SendUserEkskulModelResponse> response) {
                    if (response.isSuccessful()){
                        view.doneProgress();
                    }
                }

                @Override
                public void onFailure(Call<SendUserEkskulModelResponse> call, Throwable t) {

                }
            });
            return null;
        }
    }


}
