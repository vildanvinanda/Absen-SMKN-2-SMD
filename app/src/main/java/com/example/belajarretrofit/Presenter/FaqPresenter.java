package com.example.belajarretrofit.Presenter;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.ProfilSetting.ModelFAQResponse;
import com.example.belajarretrofit.View.FaqView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaqPresenter {

    FaqView view;

    public FaqPresenter(FaqView view) {
        this.view = view;
    }


    public void getFaq() {

        ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
        Call<List<ModelFAQResponse>> call = apiInterface.getfaq();
        call.enqueue(new Callback<List<ModelFAQResponse>>() {
            @Override
            public void onResponse(Call<List<ModelFAQResponse>> call, Response<List<ModelFAQResponse>> response) {
                if(response.isSuccessful()){
                    List<ModelFAQResponse> list = response.body();
                    view.onSuccess(list);
                }
            }

            @Override
            public void onFailure(Call<List<ModelFAQResponse>> call, Throwable t) {
                view.onError(t.getLocalizedMessage());
            }
        });
    }
}
