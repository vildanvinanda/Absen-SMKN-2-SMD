package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.belajarretrofit.databinding.ActivityListAllEkskulBinding;

public class ListAllEkskul extends AppCompatActivity {

    private ActivityListAllEkskulBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListAllEkskulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}