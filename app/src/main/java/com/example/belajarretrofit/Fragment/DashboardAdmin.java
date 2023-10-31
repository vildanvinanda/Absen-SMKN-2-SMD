package com.example.belajarretrofit.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.ASuperUser.ListStrukturEkstrakulikuler;
import com.example.belajarretrofit.Activity.AUser.DetailSekolah;
import com.example.belajarretrofit.Activity.AUser.ListEksktrakulikuler;
import com.example.belajarretrofit.Activity.Admin.JadwalAdmin;
import com.example.belajarretrofit.Activity.Admin.ListUser;
import com.example.belajarretrofit.Activity.Admin.ProfilAdmin;
import com.example.belajarretrofit.Activity.Admin.ViewAbsen;
import com.example.belajarretrofit.Activity.Galeri;
import com.example.belajarretrofit.Adapter.AdapterGaleri;
import com.example.belajarretrofit.Model.Galeri.ModelGaleri;
import com.example.belajarretrofit.Piala;
import com.example.belajarretrofit.Presenter.AbsenPresenter;
import com.example.belajarretrofit.Presenter.GaleriPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.GaleriView;
import com.example.belajarretrofit.databinding.FragmentDashboardAdminBinding;


import java.util.List;

public class DashboardAdmin extends Fragment implements GaleriView {
    GaleriPresenter presenter;
    SessionManager sessionManager;
    private FragmentDashboardAdminBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDashboardAdminBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        sessionManager = new SessionManager(getActivity());
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        String img = sessionManager.getUserDetail().get(SessionManager.IMG_USER);

        binding.nama.setText(nama);
        Glide.with(this).load(img).centerCrop().into(binding.imgUser);

        AllBtn();
        presenter = new GaleriPresenter(this);
        presenter.setDataGaleri();

        return view;
    }

    private void AllBtn() {
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListEksktrakulikuler.class);
                startActivity(intent);
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), Galeri.class);
                startActivity(intent);
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), Piala.class);
                startActivity(intent);
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), ListUser.class);
                startActivity(intent);
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), JadwalAdmin.class);
                startActivity(intent);
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), ListStrukturEkstrakulikuler.class);
                startActivity(intent);
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), ProfilAdmin.class);
                startActivity(intent);
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), ViewAbsen.class);
                startActivity(intent);
            }
        });

        binding.profilsekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailSekolah.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onProsess() {

    }

    @Override
    public void onError(String localizedMessage) {

    }

    @Override
    public void donePresess() {

    }

    @Override
    public void onShowData(List<ModelGaleri> galeri) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recgaleriDashboard.setLayoutManager(layoutManager);
        binding.recgaleriDashboard.setAdapter(new AdapterGaleri(getContext(),galeri));
    }
}