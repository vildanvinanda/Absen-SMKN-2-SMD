package com.example.belajarretrofit.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.ASuperUser.ListStrukturEkstrakulikuler;
import com.example.belajarretrofit.Activity.ASuperUser.StukturOrganisasi;
import com.example.belajarretrofit.Adapter.AdapterGetAllUser;
import com.example.belajarretrofit.Adapter.AdapterListEkskul;
import com.example.belajarretrofit.Presenter.DetailAllUserPresenter;
import com.example.belajarretrofit.Presenter.DetailUserEkskukPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.DetailUserEkskulInterface;
import com.example.belajarretrofit.databinding.ActivityDetailUserBinding;
import com.example.belajarretrofit.databinding.ActivityDetailUserEkskulBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DetailUserEkskul extends AppCompatActivity implements DetailUserEkskulInterface {

    DetailUserEkskukPresenter presenter;
    private ActivityDetailUserEkskulBinding binding;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailUserEkskulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new DetailUserEkskukPresenter(this);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(StukturOrganisasi.EXTRA_NAMA);
        String id = intent.getStringExtra(StukturOrganisasi.EXTRA_ID);
        String nis = intent.getStringExtra(StukturOrganisasi.EXTRA_NIS);
        String alamat = intent.getStringExtra(StukturOrganisasi.EXTRA_ALAMAT);
        String uid = intent.getStringExtra(StukturOrganisasi.EXTRA_UID);
        String nohp = intent.getStringExtra(StukturOrganisasi.EXTRA_NOHP);
        String jk = intent.getStringExtra(StukturOrganisasi.EXTRA_JK);
        String img = intent.getStringExtra(StukturOrganisasi.EXTRA_IMG);
        String status = intent.getStringExtra(StukturOrganisasi.EXTRA_STATUS);
        String kls = intent.getStringExtra(StukturOrganisasi.EXTRA_KLS);
        String namaE = intent.getStringExtra(StukturOrganisasi.EXTRA_NAMA_EKSKUL);

        binding.addNama.setText(nama);
        binding.addNis.setText(nis);
        binding.addAlasan.setText(alamat);
        binding.addNohp.setText(nohp);
        binding.addJk.setText(jk);
        binding.addKls.setText(kls);
        Glide.with(binding.addImg).load(img).centerCrop().into(binding.addImg);

        AllButton(uid, namaE,nama, nis, kls, jk, img, nohp, alamat, id, status);
    }

    private void AllButton(String uid, String namaE, String nama, String nis, String kls, String jk, String img, String nohp, String alamat, String id, String status) {
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
                String[] jabatan = {"Pilih Status", "Ketua", "Wakil", "Sekretaris", "Bendahara", "Absen", "Anggota"};

                adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, jabatan);
                adapter.setDropDownViewResource(R.layout.spinner_item);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        DetailUserEkskul.this, R.style.BottomSheetDialogTheme
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
                            presenter.addJabatan(namaE, uid, jabatan);
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
                presenter.deleteItem(namaE,uid);
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
    public void onSuccses(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DetailUserEkskul.this, ListStrukturEkstrakulikuler.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSuccsesDelete(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DetailUserEkskul.this, ListStrukturEkstrakulikuler.class);
        startActivity(intent);
        finish();
    }
}