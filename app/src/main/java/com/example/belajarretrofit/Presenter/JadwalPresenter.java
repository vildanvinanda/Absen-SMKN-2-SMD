//package com.example.belajarretrofit.Presenter;
//
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.belajarretrofit.APIService.ApiInterface;
//import com.example.belajarretrofit.APIService.ApiService;
//import com.example.belajarretrofit.Adapter.AdaperCalendar;
//import com.example.belajarretrofit.CalendarUtils;
//import com.example.belajarretrofit.Model.Event;
//import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
//import com.example.belajarretrofit.Model.login.Logindata;
//import com.example.belajarretrofit.Model.login.ModelLogin;
//import com.example.belajarretrofit.Model.register.ModelRegister;
//import com.example.belajarretrofit.SessionManager;
//import com.example.belajarretrofit.View.JadwalView;
//import com.example.belajarretrofit.View.LoginView;
//import com.example.belajarretrofit.View.RegisterView;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import static com.example.belajarretrofit.CalendarUtils.daysInWeekArray;
//import static com.example.belajarretrofit.CalendarUtils.monthYearFromDate;
//
//public class JadwalPresenter {
//
//
//    private JadwalView view;
//
//    public JadwalPresenter(JadwalView view) {
//        this.view = view;
//    }
//
//
//    public void getDataJadwal(){
//        view.showProgress();
//
//        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
//        Call<List<ModelJadwal>> call = apiInterface.getJadwal();
//        call.enqueue(new Callback<List<ModelJadwal>>() {
//            @Override
//            public void onResponse(Call<List<ModelJadwal>> call, Response<List<ModelJadwal>> response) {
//                view.hideProgress();
//                if (response.isSuccessful() && response.body() != null){
//                    view.onGetResult(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ModelJadwal>> call, Throwable t) {
//                view.hideProgress();
//                view.onError(t.getLocalizedMessage());
//            }
//        });
//    }
//
//
//    public void createEvent(String takeJudul, String takeJam, String takeTempat, String takeHari, String takeEkskul, LocalDate selectedDate, LocalTime time) {
//        view.showProgress();
//        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
//        Call<ModelJadwal> jadwalCall = apiInterface.jadwalResponse("",takeJudul,takeJam,takeTempat, takeHari, takeEkskul, selectedDate, time);
////        Call<ModelRegister> loginCall = apiInterface.loginResponse(email,password);
//        jadwalCall.enqueue(new Callback<ModelJadwal>() {
//            @Override
//            public void onResponse(Call<ModelJadwal> call, Response<ModelJadwal> response) {
//                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
//                    //Ini untuk pindah
//                    //ngambil data yang login. h
//                    view.hideProgress();
//                    view.onSuccsess(response.body().getMessage());
////
//                } else {
//                    view.hideProgress();
//                    view.onFailure(response.body().getMessage());
////                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelJadwal> call, Throwable t) {
//                view.hideProgress();
//                view.onError(t.getLocalizedMessage());
////                Toast.makeText(Register.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//}



package com.example.belajarretrofit.Presenter;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Adapter.AdaperCalendar;
import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.Model.Event;
import com.example.belajarretrofit.Model.jadwal.JadwalModel;
import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.Model.login.ModelLogin;
import com.example.belajarretrofit.Model.register.ModelRegister;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.JadwalView;
import com.example.belajarretrofit.View.LoginView;
import com.example.belajarretrofit.View.RegisterView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.belajarretrofit.CalendarUtils.daysInWeekArray;
import static com.example.belajarretrofit.CalendarUtils.monthYearFromDate;

public class JadwalPresenter {

    private JadwalView view;

    public JadwalPresenter(JadwalView view) {
        this.view = view;
    }

    public void getData(String tgl){
        view.showProgress();

        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<JadwalModel>> call = apiInterface.getJadwal(tgl);
        call.enqueue(new Callback<List<JadwalModel>>() {
            @Override
            public void onResponse(Call<List<JadwalModel>> call, Response<List<JadwalModel>> response) {
                view.hideProgress();
                if (response.isSuccessful()){
                    List<JadwalModel> items = response.body();
                    view.onGetResult(items);
                }
            }

            @Override
            public void onFailure(Call<List<JadwalModel>> call, Throwable t) {
                view.hideProgress();
                view.onError(t.getLocalizedMessage());
            }
        });
    }


    public void createEvent(String takeJudul, String takeJam, String takeTempat, String takeHari, String takeEkskul, LocalDate selectedDate, LocalTime time) {
        view.showProgress();
        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<ModelJadwal> jadwalCall = apiInterface.jadwalResponse("",takeJudul,takeJam,takeTempat, takeHari, takeEkskul, selectedDate, time);
//        Call<ModelRegister> loginCall = apiInterface.loginResponse(email,password);
        jadwalCall.enqueue(new Callback<ModelJadwal>() {
            @Override
            public void onResponse(Call<ModelJadwal> call, Response<ModelJadwal> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    //Ini untuk pindah
                    //ngambil data yang login. h
                    view.hideProgress();
                    view.onSuccsess(response.body().getMessage());
//
                } else {
                    view.hideProgress();
                    view.onFailure(response.body().getMessage());
//                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelJadwal> call, Throwable t) {
                view.hideProgress();
                view.onError(t.getLocalizedMessage());
//                Toast.makeText(Register.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
