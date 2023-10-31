package com.example.belajarretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.Presenter.ProfilSettingPresenter;
import com.example.belajarretrofit.ProfilSetting;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.ProfilSettingVIew;
import com.example.belajarretrofit.databinding.ActivityUbahDataProfilBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class UbahDataProfil extends AppCompatActivity implements ProfilSettingVIew {


    private ActivityUbahDataProfilBinding binding;
    ProfilSettingPresenter presenter;
    SessionManager sessionManager;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUbahDataProfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(UbahDataProfil.this, ProfilSetting.class);
//                startActivity(intent);
                finish();
            }
        });

        sessionManager = new SessionManager(getApplicationContext());
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        String kls = sessionManager.getUserDetail().get(SessionManager.KELAS);
        String nis = sessionManager.getUserDetail().get(SessionManager.NIS);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);

        if (type.equals("user")) {
            binding.userDomain.setVisibility(View.VISIBLE);
            binding.adminDomain.setVisibility(View.GONE);
        } else {
            binding.userDomain.setVisibility(View.GONE);
            binding.adminDomain.setVisibility(View.VISIBLE);
        }

        presenter = new ProfilSettingPresenter(this);
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        AllButton(uid, nama, kls, nis);

    }

    private void AllButton(String uid, String nama, String kls, String nis) {
        binding.rowrightAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_ubahuser, (RelativeLayout) findViewById(R.id.bottomubahusername)
                        );
                EditText edduser = (EditText) bottomSheetView.findViewById(R.id.edduser);
//                ImageView btnclosefilter = bottomSheetView.findViewById(R.id.btnclosefilter);
                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.btnubahusername).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String addname = edduser.getText().toString().trim();

                        if (TextUtils.isEmpty(addname)) {
                            edduser.requestFocus();
                            edduser.setError("Tolong diisi");
                        } else {
                            presenter.updateName(uid,addname);
//                            Toast.makeText(UbahDataProfil.this, "Nama telah diubah", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        binding.rowright2Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_ubahnomor, (RelativeLayout) findViewById(R.id.bottomubahnohp)
                        );

//                ImageView btnclosefilter = bottomSheetView.findViewById(R.id.btnclosefilter);
                EditText eddnomor = (EditText) bottomSheetView.findViewById(R.id.eddnomerhp);
                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetView.findViewById(R.id.btnubahnohp).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String addnomor = eddnomor.getText().toString().trim();

                        if (TextUtils.isEmpty(addnomor)) {
                            eddnomor.requestFocus();
                            eddnomor.setError("Tolong diisi");
                        } else {
                            presenter.updateNomor(uid,addnomor);
//                            Toast.makeText(UbahDataProfil.this, "Nomor telah diubah", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        binding.rowright3Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_alamat, (RelativeLayout) findViewById(R.id.modalalamat)
                        );
                EditText eddalamat = (EditText) bottomSheetView.findViewById(R.id.eddalamat);
//                ImageView btnclosefilter = bottomSheetView.findViewById(R.id.btnclosefilter);
                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.btnupdatealamat).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String alamat = eddalamat.getText().toString();
                        if (TextUtils.isEmpty(alamat)) {
                            eddalamat.requestFocus();
                            eddalamat.setError("Tolong diisi");
                        } else {
                            presenter.updateAlamat(uid,alamat);
//                            Toast.makeText(UbahDataProfil.this, "Alamat telah diubah", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        binding.rowright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_ubahuser, (RelativeLayout) findViewById(R.id.bottomubahusername)
                        );
                EditText edduser = (EditText) bottomSheetView.findViewById(R.id.edduser);
//                ImageView btnclosefilter = bottomSheetView.findViewById(R.id.btnclosefilter);
                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.btnubahusername).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String addname = edduser.getText().toString().trim();

                        if (TextUtils.isEmpty(addname)) {
                            edduser.requestFocus();
                            edduser.setError("Tolong diisi");
                        } else {
//                            updateName(addname);
//                            updateName2(addname);
//                            updateName3(addname);
                            presenter.updateName(uid,addname);
//                            Toast.makeText(UbahDataProfil.this, "Data telah diubah", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        binding.rowright2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_ubahnomor, (RelativeLayout) findViewById(R.id.bottomubahnohp)
                        );

//                ImageView btnclosefilter = bottomSheetView.findViewById(R.id.btnclosefilter);
                EditText eddnomor = (EditText) bottomSheetView.findViewById(R.id.eddnomerhp);
                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetView.findViewById(R.id.btnubahnohp).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String addnomor = eddnomor.getText().toString().trim();

                        if (TextUtils.isEmpty(addnomor)) {
                            eddnomor.requestFocus();
                            eddnomor.setError("Tolong diisi");
                        } else {
                            presenter.updateNomor(uid, addnomor);

//                            Toast.makeText(UbahDataProfil.this, "nomor telah diubah", Toast.LENGTH_SHORT).show();
                        }


                    }

                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        binding.rowright3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_ubahgender, (RelativeLayout) findViewById(R.id.bottomupdateJK)
                        );

                RadioGroup radiongrup = (RadioGroup) bottomSheetView.findViewById(R.id.radiongrup);


//                ImageView btnclosefilter = bottomSheetView.findViewById(R.id.btnclosefilter);
                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetView.findViewById(R.id.btnupdatejk).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                        Toast.makeText(UbahDataProfil.this, "Janis kelamin telah diubah", Toast.LENGTH_SHORT).show();
                        radiongrup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                RadioButton radio_laki = (RadioButton) bottomSheetView.findViewById(R.id.radio_laki);
                                RadioButton radio_cewe = (RadioButton) bottomSheetView.findViewById(R.id.radio_cewe);

                                String g1 = radio_laki.getText().toString();
                                String g2 = radio_cewe.getText().toString();

                                Button btnupdateJK = (Button) bottomSheetView.findViewById(R.id.btnupdatejk);
                                btnupdateJK.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (radio_laki.isChecked()) {
                                            presenter.updateJKL(uid,g1);
                                        } else {
                                            presenter.updateJKP(uid,g2);
                                        }
//                                        Toast.makeText(UbahDataProfil.this, "Jenis kelamin diubah", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        });
                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        binding.rowright4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> spinnerList;
                ArrayList<String> spinnerList2;
                ArrayAdapter<String> adapter, adapter2;
                String[] kelas = {"Pilih Kelas", "X", "XI", "XII"};
                String[] jurusan = {"Pilih Jurusan", "RPL", "TKRO", "TBSM", "TPTL", "TKJ", "OTOTRONIK"};

                spinnerList = new ArrayList<>();
                spinnerList2 = new ArrayList<>();

                adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, kelas);
                adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, jurusan);
                adapter.setDropDownViewResource(R.layout.spinner_item);
                adapter2.setDropDownViewResource(R.layout.spinner_item);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_ubahkelas, (RelativeLayout) findViewById(R.id.bottomubahkelas)
                        );

                Spinner addkelas = (Spinner) bottomSheetView.findViewById(R.id.addkelas);
                Spinner addjurusan = (Spinner) bottomSheetView.findViewById(R.id.addjurusan);
                addkelas.setAdapter(adapter);
                addjurusan.setAdapter(adapter2);

                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetView.findViewById(R.id.btnubahkls).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String jurusan = addjurusan.getSelectedItem().toString();
                        String kelas = addkelas.getSelectedItem().toString();

                        if (kelas.equals("Pilih Kelas")) {
                            addkelas.requestFocus();
                        } else if (jurusan.equals("Pilih Jurusan")) {
                            addjurusan.requestFocus();
                        } else {
                            String kls = kelas+"-"+jurusan;
                            presenter.updateKelas(uid,kls);
                        }

                    }

                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        binding.rowright5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        UbahDataProfil.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_alamat, (RelativeLayout) findViewById(R.id.modalalamat)
                        );
                EditText eddalamat = (EditText) bottomSheetView.findViewById(R.id.eddalamat);
//                ImageView btnclosefilter = bottomSheetView.findViewById(R.id.btnclosefilter);
                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.btnupdatealamat).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String alamat = eddalamat.getText().toString();
                        if (TextUtils.isEmpty(alamat)) {
                            eddalamat.requestFocus();
                            eddalamat.setError("Tolong diisi");
                        } else {
                            presenter.updateAlamat(uid,alamat);
//                            Toast.makeText(UbahDataProfil.this, "Alamat telah diubah", Toast.LENGTH_SHORT).show();
                        }

                    }

                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
    }

//    @Override
//    public void onSuccsess(String s, String nama, String kls, String alamat, String jk, String message) {
//        SessionManager sessionManager = new SessionManager(this);
//        sessionManager.updateUserData(s,nama,kls,alamat,jk,message);
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgress() {
        dialog.show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doneProgress() {
        dialog.dismiss();
    }


    @Override
    public void onPassSuccsess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNamaSuccsess(SessionManager sessionManager, String message, String addname) {
        sessionManager = new SessionManager(UbahDataProfil.this);
        sessionManager.updateNamaUserData(addname);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNomorSuccsess(SessionManager sessionManager, String message, String addnomor) {
        sessionManager = new SessionManager(UbahDataProfil.this);
        sessionManager.updateNomorUserData(addnomor);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onG1Succsess(SessionManager sessionManager, String message, String g1) {
        sessionManager = new SessionManager(UbahDataProfil.this);
        sessionManager.updateG1UserData(g1);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onG2Succsess(SessionManager sessionManager, String message, String g2) {
        sessionManager = new SessionManager(UbahDataProfil.this);
        sessionManager.updateG2UserData(g2);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onKelasSuccsess(SessionManager sessionManager, String message, String kls) {
        sessionManager = new SessionManager(UbahDataProfil.this);
        sessionManager.updateKelasUserData(kls);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAlamatSuccsess(SessionManager sessionManager, String message, String alamat) {
        sessionManager = new SessionManager(UbahDataProfil.this);
        sessionManager.updateAlamatUserData(alamat);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}