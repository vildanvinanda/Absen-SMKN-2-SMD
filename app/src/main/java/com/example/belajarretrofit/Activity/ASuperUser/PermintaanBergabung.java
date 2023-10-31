package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.belajarretrofit.Adapter.AdapterReqBasket;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.Presenter.PermintaanBergabungPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.PermintaanBergabungInterface;
import com.example.belajarretrofit.View.itemClick.RecyclerViewItemClickListener;
import com.example.belajarretrofit.databinding.ActivityPermintaanBergabungBinding;

import java.util.List;

public class PermintaanBergabung extends AppCompatActivity implements PermintaanBergabungInterface, RecyclerViewItemClickListener {

    PermintaanBergabungPresenter presenter;
    private ActivityPermintaanBergabungBinding binding;
    SessionManager sessionManager;
    private String Daftar;
    ProgressDialog dialog;


    //extra
    public static final String EXTRA_ID = "id_daf_ek";
    public static final String EXTRA_UID = "uid";
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_NIS = "nis";
    public static final String EXTRA_IMG = "img";
    public static final String EXTRA_ALAMAT = "alamat";
    public static final String EXTRA_ALASAN = "alasan";
    public static final String EXTRA_KLS = "kelas";
    public static final String EXTRA_JK = "jk";
    public static final String EXTRA_NOHP= "nohp";
    public static final String EXTRA_NAMA_EKSKUL= "namaE";
    String EXTRA_EKSKUL= "namaEks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPermintaanBergabungBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //jika pada kolom 1 user bukan merupakan anggota maka user dapat melihat daftar anggota pada
        sessionManager = new SessionManager(this);
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);

        presenter = new PermintaanBergabungPresenter(this);
        presenter.onGetEkskul(uid);

        binding.kolom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        binding.kolom2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

    }

    @Override
    public void onSuccess(List<ModelReq> model, String jml) {
        binding.jml.setText(jml);
        binding.recListReq.setAdapter(new AdapterReqBasket(getApplicationContext(),model, this));
        binding.recListReq.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess2(String status, String kolom2) {
    }

    @Override
    public void onSuccessForGetDaf(List<ModelReq> body, String jml) {
        binding.jml.setText(jml);
        binding.recListReq.setAdapter(new AdapterReqBasket(getApplicationContext(),body, this));
        binding.recListReq.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onSuccessGetKolom(String kolom1, String kolom2, String uid) {
        presenter.getList(kolom1);
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
        binding.kolom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.kolom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                binding.kolom2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                presenter.getList(kolom1);
                Daftar = kolom1;
            }
        });

        binding.kolom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.kolom2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                binding.kolom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                presenter.getList(kolom2);
                Daftar = kolom2;
            }
        });

        binding.kolomsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence keyword, int start, int before, int count) {
                if (keyword.toString()!=null)
                {
//                    presenter.getDataFilter(keyword.toString());
//                    if (Daftar.equals(kolom1)){
//
//                    } else if (Daftar.equals(kolom2)){
//                        presenter.getDataFilter2(keyword.toString(),kolom2);
//                    }
                    presenter.getDataFilter(keyword.toString(),Daftar);


                }
                else
                {
//                    presenter.getDataEkskul();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onProgress() {
        dialog.show();
    }

    @Override
    public void doneProgress() {
        dialog.dismiss();
    }

    @Override
    public void onEmptyData() {
        Toast.makeText(this, "Maaf tidak ada yang mendaftar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(int position, List<ModelReq> modelQeqBaskets) {
        ModelReq modelReq = modelQeqBaskets.get(position);
        Intent intent = new Intent(PermintaanBergabung.this, DafDetailUser.class);
        intent.putExtra(EXTRA_ID, modelReq.getId_daf_ek());
        intent.putExtra(EXTRA_UID, modelReq.getUid());
        intent.putExtra(EXTRA_NAMA, modelReq.getNama());
        intent.putExtra(EXTRA_IMG, modelReq.getImg_user());
        intent.putExtra(EXTRA_NIS, modelReq.getNis());
        intent.putExtra(EXTRA_ALAMAT, modelReq.getAlamat());
        intent.putExtra(EXTRA_ALASAN, modelReq.getAlasan());
        intent.putExtra(EXTRA_KLS, modelReq.getKls());
        intent.putExtra(EXTRA_JK, modelReq.getJk());
        intent.putExtra(EXTRA_NOHP, modelReq.getNohp());
        intent.putExtra(EXTRA_NAMA_EKSKUL, Daftar);
        startActivity(intent);

//        startActivity(intent);
    }


//    @Override
//    public void onItemClick(int position, String id, String nama, String alamat, String alasan, String jk, String kls, String nis, String img, String nohp) {
//        Intent intent = new Intent(PermintaanBergabung.this, DetailUser.class);
//        ModelReq click = modelReqs.get(position);
////        intent.putExtra(EXTRA_ID, click);
////        intent.putExtra(EXTRA_NAMA, );
////        intent.putExtra(EXTRA_ALAMAT, alamat);
////        intent.putExtra(EXTRA_ALASAN, alasan);
////        intent.putExtra(EXTRA_JK, jk);
////        intent.putExtra(EXTRA_KLS, kls);
////        intent.putExtra(EXTRA_NIS, nis);
////        intent.putExtra(EXTRA_IMG, img);
////        intent.putExtra(EXTRA_NOHP, nohp);
//        startActivity(intent);
//    }
}