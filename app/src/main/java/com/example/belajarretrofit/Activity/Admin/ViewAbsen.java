package com.example.belajarretrofit.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.belajarretrofit.Adapter.AdapterViewAbsen;
import com.example.belajarretrofit.Model.ModelAbsen.ModelGetAbsen;
import com.example.belajarretrofit.Model.ModelGetStatusUserEk;
import com.example.belajarretrofit.Presenter.ViewAbsenPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.ViewAbsenInterface;
import com.example.belajarretrofit.View.itemClick.RecyclerAbsenClickListener;
import com.example.belajarretrofit.databinding.ActivityViewAbsenBinding;

import java.util.List;

public class ViewAbsen extends AppCompatActivity implements ViewAbsenInterface, RecyclerAbsenClickListener {

    private ActivityViewAbsenBinding binding;
    ViewAbsenPresenter presenter;
    SessionManager sessionManager;
    ProgressDialog dialog;
    private String Daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewAbsenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sessionManager = new SessionManager(this);
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);

        presenter = new ViewAbsenPresenter(this);
        binding.kolom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        binding.kolom2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        presenter.getKolom(uid);
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessGetKolom(String kolom1, String kolom2, String uid) {
        sessionManager = new SessionManager(this);
        String uid2 = sessionManager.getUserDetail().get(SessionManager.UID);

        if (kolom1.isEmpty()){
            binding.tamplatetextkolom1.setVisibility(View.GONE);
        } else if (kolom2.isEmpty()){
            binding.tamplatetextkolom2.setVisibility(View.GONE);
            binding.kolom1.setText(kolom1);

        } else{
            binding.tamplatetextkolom1.setVisibility(View.VISIBLE);
            binding.tamplatetextkolom2.setVisibility(View.VISIBLE);
            binding.kolom1.setText(kolom1);
            binding.kolom2.setText(kolom2);
        }
        Daftar = kolom1;
        presenter.getList(Daftar,uid2);
        binding.kolom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.kolom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                binding.kolom2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                Daftar = kolom1;
                presenter.getList(Daftar,uid2);

            }
        });

        binding.kolom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.kolom2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                binding.kolom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                Daftar = kolom2;
                presenter.getList(Daftar,uid2);

            }
        });


        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    @Override
    public void onSuccessForGetDaf(List<ModelGetStatusUserEk> body, String type, String kolom1) {
        if(type.equals("Anggota")){
            binding.recList.setVisibility(View.GONE);
        } else {
            binding.recList.setVisibility(View.VISIBLE);
            presenter.getViewAbsen(kolom1);
        }

    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onSuccessForGetAbsen(List<ModelGetAbsen> body, String kolom1) {
        binding.recList.setAdapter(new AdapterViewAbsen(getApplicationContext(),body, this));
        binding.recList.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onItemClick(int position, List<ModelGetAbsen> modelQeqBaskets) {

    }
}