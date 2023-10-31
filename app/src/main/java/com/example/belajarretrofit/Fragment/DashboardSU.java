package com.example.belajarretrofit.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blikoon.qrcodescanner.QrCodeActivity;
import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.ASuperUser.ListStrukturEkstrakulikuler;
import com.example.belajarretrofit.Activity.ASuperUser.PermintaanBergabung;
import com.example.belajarretrofit.Activity.AUser.DetailSekolah;
import com.example.belajarretrofit.Activity.AUser.ListEksktrakulikuler;
import com.example.belajarretrofit.Activity.Admin.ViewAbsen;
import com.example.belajarretrofit.Activity.Galeri;
import com.example.belajarretrofit.Adapter.AdapterGaleri;
import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.Model.Galeri.ModelGaleri;
import com.example.belajarretrofit.Model.ModelAbsen.ModelAbsenUser;
import com.example.belajarretrofit.Piala;
import com.example.belajarretrofit.Presenter.AbsenPresenter;
import com.example.belajarretrofit.Presenter.GaleriPresenter;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.AbsenView;
import com.example.belajarretrofit.View.GaleriView;
import com.example.belajarretrofit.databinding.FragmentDashboardSUBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.List;

public class DashboardSU extends Fragment implements GaleriView , AbsenView {
    AbsenPresenter presenterAbsen;
    GaleriPresenter presenter;
    SessionManager sessionManager;
    private FragmentDashboardSUBinding binding;
    //scann
    private static final int REQUEST_CODE_QR_SCAN = 101;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDashboardSUBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        sessionManager = new SessionManager(getActivity());
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        String img = sessionManager.getUserDetail().get(SessionManager.IMG_USER);

        binding.nama.setText(nama);
        Glide.with(this).load(img).centerCrop().into(binding.imgUser);

        AllBtn();
        presenterAbsen = new AbsenPresenter(this);
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
                Dexter.withContext(getContext())
                        .withPermission(Manifest.permission.CAMERA)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent i = new Intent(getActivity(), QrCodeActivity.class);
                                startActivityForResult( i,REQUEST_CODE_QR_SCAN);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                                permissionDeniedResponse.getRequestedPermission();
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                            }
                        }).check();
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), Galeri.class);
                startActivity(intent);
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), Piala.class);
                startActivity(intent);
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), PermintaanBergabung.class);
                startActivity(intent);
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), ViewAbsen.class);
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

        binding.profilsekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailSekolah.class);
                startActivity(intent);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode != Activity.RESULT_OK)
        {
            if(data==null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("com.blikoon.qrcodescanner.error_decoding_image");
            if( result!=null)
            {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Scan Error");
                alertDialog.setMessage("QR Code could not be scanned");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
            return;

        }
        if(requestCode == REQUEST_CODE_QR_SCAN)
        {
            if(data==null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("com.blikoon.qrcodescanner.got_qr_scan_relult");
//            Log.d(LOGTAG,"Have scan result in your app activity :"+ result);
//            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//            alertDialog.setTitle("Scan result");
//            alertDialog.setMessage(result);
//            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//            alertDialog.show();
//            CalendarUtils.selectedDate = LocalDate.now();
//            String tgl = String.valueOf(CalendarUtils.selectedDate);
//            Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();

            try {
                JSONObject jsonObject = new JSONObject(result);

                // Mengambil nilai berdasarkan nama kunci (key)
                String nama = jsonObject.getString("nama"); // Mengambil nilai string "nama"
                String tanggal = jsonObject.getString("tanggal"); // Mengambil nilai integer "usia"

                CalendarUtils.selectedDate = LocalDate.now();

                String qrdata = tanggal+nama;
                String qrdata2 = CalendarUtils.selectedDate+nama;

                if (qrdata.equals(qrdata2)){
//                    Toast.makeText(getActivity(), "mantap", Toast.LENGTH_LONG).show();
                    SessionManager sessionManager = new SessionManager(getContext());
                    String uid = sessionManager.getUserDetail().get(SessionManager.UID);
                    String namaUser = sessionManager.getUserDetail().get(SessionManager.NAMA);
                    String kls = sessionManager.getUserDetail().get(SessionManager.KELAS);
                    String nis = sessionManager.getUserDetail().get(SessionManager.NIS);

                    presenterAbsen.addAbsen(uid,nama,tanggal,namaUser,kls,nis);

                } else {
//                    Toast.makeText(getActivity(), "maaf salah", Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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

    @Override
    public void onProgressAbsen() {

    }

    @Override
    public void doneProgressAbsen() {

    }

    @Override
    public void onSuccsessAbsen(ModelAbsenUser message) {
        Toast.makeText(getActivity(), "Selamat Anda Telah Mengisi Absen ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureAbsen() {

    }

    @Override
    public void onErrorAbsen() {

    }
}