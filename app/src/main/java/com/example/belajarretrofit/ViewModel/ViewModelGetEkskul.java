package com.example.belajarretrofit.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.APIService.ApiService;
import com.example.belajarretrofit.Model.Ekskul.ModelGetEkskul;
import com.example.belajarretrofit.Presenter.StrukturOrganisasiPresenter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelGetEkskul extends ViewModel {
    private MutableLiveData<List<ModelGetEkskul>> data = new MutableLiveData<>();


    public LiveData<List<ModelGetEkskul>> getData() {
        return data;
    }

}
