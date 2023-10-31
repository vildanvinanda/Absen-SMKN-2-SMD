package com.example.belajarretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.belajarretrofit.Adapter.AdapterFaq;
import com.example.belajarretrofit.Adapter.AdapterGaleri;
import com.example.belajarretrofit.Model.ProfilSetting.ModelFAQResponse;
import com.example.belajarretrofit.Presenter.FaqPresenter;
import com.example.belajarretrofit.View.FaqView;
import com.example.belajarretrofit.databinding.ActivityFaqBinding;

import java.util.List;

public class FAQ extends AppCompatActivity implements FaqView {

    private FaqPresenter presenter;
    private ActivityFaqBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFaqBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        presenter = new FaqPresenter(this);
        presenter.getFaq();


    }

    @Override
    public void onSuccess(List<ModelFAQResponse> list) {
        binding.recfaq.setAdapter(new AdapterFaq(getApplicationContext(),list));
        binding.recfaq.setLayoutManager(new GridLayoutManager(this,2));
        binding.recfaq.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onError(String localizedMessage) {

    }

    @Override
    public void onProgress() {

    }

    @Override
    public void doneProgress() {

    }
}