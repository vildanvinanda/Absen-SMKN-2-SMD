package com.example.belajarretrofit.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.belajarretrofit.Adapter.AdapterEvent;
import com.example.belajarretrofit.Adapter.AdapterRiwayat;
import com.example.belajarretrofit.MainActivity;
import com.example.belajarretrofit.Model.riwayat.ModelRiwayat;
import com.example.belajarretrofit.Presenter.RiwayatPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.RiwayatView;
import com.example.belajarretrofit.databinding.FragmentRiwayatBinding;

import java.util.ArrayList;
import java.util.List;


public class Riwayat extends Fragment implements RiwayatView {

    private RiwayatPresenter riwayatPresenter;
    private FragmentRiwayatBinding binding;
    private SessionManager sessionManager;
    AdapterRiwayat adapterRiwayat;
    ProgressDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRiwayatBinding.inflate(inflater, container,false);
        View view = binding.getRoot();


//        List<ModelRiwayat> modelRiwayats = new ArrayList<ModelRiwayat>();
//        modelRiwayats.add(new ModelRiwayat("Selamat anda bergabung dengan ekskul basket","04-04-2023"));
//        modelRiwayats.add(new ModelRiwayat("Selamat anda bergabung dengan ekskul basket","04-04-2023"));
//        modelRiwayats.add(new ModelRiwayat("Selamat anda bergabung dengan ekskul basket","04-04-2023"));
//

        dialog = new ProgressDialog(getContext());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        //ini adalah sebuah objek sesi
        //kita tambahkan kondisi
        sessionManager = new SessionManager(getActivity());

        //letakan data yang ada di hasmap ke textview
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        riwayatPresenter = new RiwayatPresenter(this);
        riwayatPresenter.setDataRiwayat(uid);

        return view;
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
    public void onGetResult(List<ModelRiwayat> uid) {
        adapterRiwayat = new AdapterRiwayat(getContext(),uid);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        binding.recRiwayat.setLayoutManager(layoutManager);
        binding.recRiwayat.setAdapter(adapterRiwayat);
    }

}