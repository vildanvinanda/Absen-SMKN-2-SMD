package com.example.belajarretrofit.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Adapter.AdapterGetAllUser;
import com.example.belajarretrofit.Presenter.DetailAllUserPresenter;
import com.example.belajarretrofit.Presenter.DetailUserPresenter;
import com.example.belajarretrofit.ProfilSetting;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.DetailAllUserInterface;
import com.example.belajarretrofit.View.DetailUserInterface;
import com.example.belajarretrofit.databinding.ActivityDetailUserBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DetailUser extends AppCompatActivity implements DetailAllUserInterface {

    DetailAllUserPresenter presenter;
    private ActivityDetailUserBinding binding;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new DetailAllUserPresenter(this);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(AdapterGetAllUser.EXTRA_NAMA);
        String nis = intent.getStringExtra(AdapterGetAllUser.EXTRA_NIS);
        String alamat = intent.getStringExtra(AdapterGetAllUser.EXTRA_ALAMAT);
        String uid = intent.getStringExtra(AdapterGetAllUser.EXTRA_UID);
        String type = intent.getStringExtra(AdapterGetAllUser.EXTRA_TYPEUSER);
        String nohp = intent.getStringExtra(AdapterGetAllUser.EXTRA_NOHP);
        String jk = intent.getStringExtra(AdapterGetAllUser.EXTRA_JK);
        String kls = intent.getStringExtra(AdapterGetAllUser.EXTRA_KLS);
        String img = intent.getStringExtra(AdapterGetAllUser.EXTRA_IMG);
        String email = intent.getStringExtra(AdapterGetAllUser.EXTRA_EMAIL);

        binding.addNama.setText(nama);
        binding.addNis.setText(nis);
        binding.addAlasan.setText(alamat);
        binding.addNohp.setText(nohp);
        binding.addJk.setText(jk);
        binding.addKls.setText(kls);
        Glide.with(binding.addImg).load(img).centerCrop().into(binding.addImg);


        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);


        allButton(uid,nama, nis, kls, jk, img, nohp, alamat);
    }

    private void allButton(String uid, String nama, String nis, String kls, String jk, String img, String nohp, String alamat) {
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnTerima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                presenter.sendUserToEkskul(uid,nama, nis, kls, jk, img, nohp, alamat, uid);
                ArrayAdapter<String> adapter;
                String[] jabatan = {"Pilih Status", "user", "super user", "admin"};

                adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, jabatan);
                adapter.setDropDownViewResource(R.layout.spinner_item);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        DetailUser.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_promosi, (RelativeLayout) findViewById(R.id.bottompromosi)
                        );

                Spinner addJabatan = (Spinner) bottomSheetView.findViewById(R.id.promosikan);
                addJabatan.setAdapter(adapter);

                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetView.findViewById(R.id.btnpromosi).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String jabatan = addJabatan.getSelectedItem().toString();

                        if(jabatan.equals("Pilih Status")){
                            addJabatan.requestFocus();
                        }else {
                            presenter.addJabatan(uid, jabatan);
                        }
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
        binding.btnTolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.deleteItem(uid);
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
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccses(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DetailUser.this, ListUser.class);
        startActivity(intent);
        finish();
    }
}