package com.example.belajarretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.belajarretrofit.Activity.AUser.UserDashboardUser;
import com.example.belajarretrofit.Activity.FAQ;
import com.example.belajarretrofit.Activity.Login;
import com.example.belajarretrofit.Activity.UbahDataProfil;
import com.example.belajarretrofit.Fragment.Profile;
import com.example.belajarretrofit.Model.login.Logindata;
import com.example.belajarretrofit.Presenter.ProfilSettingPresenter;
import com.example.belajarretrofit.View.ProfilSettingVIew;
import com.example.belajarretrofit.databinding.ActivityDashboardUserBinding;
import com.example.belajarretrofit.databinding.ActivityProfilSettingBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ProfilSetting extends AppCompatActivity implements ProfilSettingVIew {
    ProgressDialog dialog;
    private ActivityProfilSettingBinding binding;
//    ProfilSettingPresenter presenter;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfilSettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent intent = getIntent();
        String type = intent.getStringExtra("STATUS");
        binding.txtType.setText(type);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        String cekType = binding.txtType.getText().toString();

        if(cekType.equals("admin")){
            binding.userDomain.setVisibility(View.GONE);
            binding.adminDomain.setVisibility(View.VISIBLE);
        } else {
            binding.userDomain.setVisibility(View.VISIBLE);
            binding.adminDomain.setVisibility(View.GONE);
        }

        ProfilSettingPresenter presenter = new ProfilSettingPresenter(this);
        sessionManager = new SessionManager(getApplicationContext());
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        String kls = sessionManager.getUserDetail().get(SessionManager.KELAS);
        String nis = sessionManager.getUserDetail().get(SessionManager.NIS);
        String typeuser = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilSetting.this, UserDashboardUser.class);
                intent.putExtra("key", typeuser); // Contoh: Mengirim data dengan kunci "key"
                startActivity(intent);
            }
        });
        AllButton(uid, nama, kls, nis);

    }

    private void AllButton(String nis, String nama, String kls, String uid) {
        ProfilSettingPresenter presenter = new ProfilSettingPresenter(this);

        //Tombol Ubah Password
        binding.rowright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        ProfilSetting.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_ubahpass, (RelativeLayout) findViewById(R.id.bottomubahpassword)
                        );

                EditText eddpassebelum = (EditText) bottomSheetView.findViewById(R.id.eddpassebelum);
                EditText eddpassesudah = (EditText) bottomSheetView.findViewById(R.id.eddpassesudah);

                bottomSheetView.findViewById(R.id.btnclosemodal).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                   bottomSheetView.findViewById(R.id.btnubahpass).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String oldPass = eddpassebelum.getText().toString().trim();
                        String newPass = eddpassesudah.getText().toString().trim();

                        if(TextUtils.isEmpty(oldPass)){
                            eddpassebelum.requestFocus();
                            eddpassebelum.setError("Tolong diisi");
                        }else if (newPass.length()<6){
                            eddpassesudah.requestFocus();
                            eddpassesudah.setError("Tolong diisi");
                        } else {
                            presenter.updatePassword(uid, oldPass, newPass);
                        }
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        //Tombol Pindah ke UbahDataProfil
        binding.rowright2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(ProfilSetting.this, UbahDataProfil.class);
                startActivity(in);
            }
        });

        //Tombol Media Sosial
        binding.rowright3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        ProfilSetting.this, R.style.BottomSheetDialogTheme
                );


                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.modal_callme, (RelativeLayout) findViewById(R.id.bottomcallme)
                        );

                bottomSheetView.findViewById(R.id.btnclosefilter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetView.findViewById(R.id.logo_wa).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String no_admin = "+6282121072289";
                        String semuapesan = "Email :"+nama+"\n"+"NIS :"+nis+"\n"+"Kelas :"+kls;

                        Intent kirimWa = new Intent("android.intent.action.MAIN");
                        kirimWa.setType("text/plaint");
                        kirimWa.putExtra(Intent.EXTRA_TEXT, semuapesan);
                        kirimWa.setAction(Intent.ACTION_SEND);
                        kirimWa.putExtra("jid", "+6282127602881"+"@s.whatsapp.net");
                        kirimWa.setPackage("com.whatsapp");


                        try {
                            startActivity(kirimWa);
                        } catch (ActivityNotFoundException ex) {
                            // WhatsApp belum terinstal
                            Toast.makeText(ProfilSetting.this, "WhatsApp belum terinstal di perangkat Anda.", Toast.LENGTH_SHORT).show();
                        }

//                        Toast.makeText(ProfilSetting.this, "Belum tersedia", Toast.LENGTH_SHORT).show();

                    }
                });

                bottomSheetView.findViewById(R.id.logo_ig).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("https://www.instagram.com/osissmknsituraja/");
                        Intent followme = new Intent(Intent.ACTION_VIEW, uri);

                        followme.setPackage("com.instagram.android");

                        try {
                            startActivity(followme);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.instagram.com/mmuurrryy/")));
                        }

                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        //Tombol FAQ
        binding.rowright4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(ProfilSetting.this, FAQ.class);
                startActivity(in);
            }
        });

        //Tombol Keluar
        binding.rowright5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLogout();
            }
        });
    }

    private void moveToLogout() {
        //berikan fungsi
        sessionManager.logoutSession();
        Intent intent = new Intent(ProfilSetting.this, Login.class);
        //gunakan setFlags untuk data data yang di dalam mann activity
        //menggunakan Flag_Activity_No_History berguna suaya data yang ada di maiin activity ini gk adak lagi
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

//    @Override
//    public void onSuccsess(String s, String nama, String kls, String alamat, String jk, String message) {
////        dialog.dismiss();
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onError(String localizedMessage) {
        dialog.dismiss();
    }

    @Override
    public void onProgress() {
        dialog.show();
    }

    @Override
    public void onFailure(String message) {
        dialog.dismiss();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doneProgress() {
        dialog.dismiss();
    }

    @Override
    public void onPassSuccsess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNamaSuccsess(SessionManager sessionManager, String message, String addname) {

    }

    @Override
    public void onNomorSuccsess(SessionManager sessionManager, String message, String addnomor) {

    }

    @Override
    public void onG1Succsess(SessionManager sessionManager, String message, String g1) {

    }

    @Override
    public void onG2Succsess(SessionManager sessionManager, String message, String g2) {

    }

    @Override
    public void onKelasSuccsess(SessionManager sessionManager, String message, String kls) {

    }

    @Override
    public void onAlamatSuccsess(SessionManager sessionManager, String message, String alamat) {

    }


}