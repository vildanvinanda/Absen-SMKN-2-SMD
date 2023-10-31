package com.example.belajarretrofit.Activity.AUser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.belajarretrofit.Activity.ASuperUser.ListStrukturEkstrakulikuler;
import com.example.belajarretrofit.Activity.Admin.TambahEkskul;
import com.example.belajarretrofit.Adapter.AdapterEkskul;
import com.example.belajarretrofit.Adapter.AdapterRiwayat;
import com.example.belajarretrofit.Model.Ekskul.ModelEkskul;
import com.example.belajarretrofit.Presenter.ListEkskulPresenter;
import com.example.belajarretrofit.Presenter.RiwayatPresenter;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.ListEkskulView;
import com.example.belajarretrofit.databinding.ActivityListEksktrakulikulerBinding;

import java.util.ArrayList;
import java.util.List;

public class ListEksktrakulikuler extends AppCompatActivity implements ListEkskulView {

    private ActivityListEksktrakulikulerBinding binding;
    private ListEkskulPresenter listEkskulPresenter;
    private ProgressDialog dialog;
    AdapterEkskul adapterEkskul;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListEksktrakulikulerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sessionManager = new SessionManager(this);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        if (type.equals("admin")){
            binding.btnTambahEkskul.setVisibility(View.VISIBLE);
            binding.btnTambahEkskul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ListEksktrakulikuler.this, TambahEkskul.class);
                    startActivity(intent);
                }
            });
        } else {
            binding.btnTambahEkskul.setVisibility(View.GONE);
        }

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.kolomsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence keyword, int start, int before, int count) {
//                Toast.makeText(ListEksktrakulikuler.this, "Proses pencarian", Toast.LENGTH_SHORT).show();

                if (keyword.toString()!=null)
                {
                    listEkskulPresenter.getDataFilter(keyword.toString());
                }
                else
                {
                    listEkskulPresenter.getDataEkskul();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        listEkskulPresenter = new ListEkskulPresenter(this);
        listEkskulPresenter.getDataEkskul();


    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void onSuccsess(String message) {

    }

    @Override
    public void onFailure(String message) {

    }

    @Override
    public void onError(String localizedMessage) {

    }

    @Override
    public void onGetResult(List<ModelEkskul> model) {
//        List<ModelEkskul> modelEkskuls = new ArrayList<>();
//        /LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.recListEkskul.setAdapter(new AdapterEkskul(getApplicationContext(),model));
        binding.recListEkskul.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

//        adapterEkskul = new AdapterEkskul(getApplicationContext(),model);
//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//        binding.recListEkskul.setLayoutManager(layoutManager);
//        binding.recListEkskul.setAdapter(adapterEkskul);

    }
}