package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.belajarretrofit.Activity.Admin.DetailUserEkskul;
import com.example.belajarretrofit.Adapter.AdapterListEkskul;
import com.example.belajarretrofit.Adapter.AdapterReqBasket;
import com.example.belajarretrofit.Model.Ekskul.ModelGetEkskul;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.Presenter.StrukturOrganisasiPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.StrukturOrganisasiInterface;
import com.example.belajarretrofit.View.itemClick.RecyclerViewItemClickForAdapterListEkskul;
import com.example.belajarretrofit.databinding.ActivityStukturOrganisasiBinding;

import java.util.List;

import static com.example.belajarretrofit.Activity.ASuperUser.ListStrukturEkstrakulikuler.EXTRA_NAMAE;

public class StukturOrganisasi extends AppCompatActivity implements StrukturOrganisasiInterface, RecyclerViewItemClickForAdapterListEkskul {

    StrukturOrganisasiPresenter presenter;

    private ActivityStukturOrganisasiBinding binding;

    public static final String EXTRA_ID= "id_ek";
    public static final String EXTRA_UID = "uid";
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_IMG = "img";
    public static final String EXTRA_NIS = "nis";
    public static final String EXTRA_ALAMAT = "alamat";
    public static final String EXTRA_KLS = "kls";
    public static final String EXTRA_JK = "jk";
    public static final String EXTRA_NOHP = "nohp";
    public static final String EXTRA_STATUS = "status";
    public static final String EXTRA_NAMA_EKSKUL = "namaE";
    String NamaE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStukturOrganisasiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String namaE = intent.getStringExtra(EXTRA_NAMAE);
        presenter = new StrukturOrganisasiPresenter(this);

        String status = "Ketua";
        String status2 = "Wakil";
        String status3 = "Sekretaris";
        String status4 = "Bendahara";
        String status5 = "Absensi";
        String status6 = "Anggota";

        presenter.onGetKetua(namaE, status);
        presenter.onGetWakil(namaE, status2);
        presenter.onGetSekretaris(namaE, status3);
        presenter.onGetBendahara(namaE, status4);
        presenter.onGetAbsensi(namaE, status5);
        presenter.onGetAnggota(namaE, status6);
        AllButton(namaE);
        binding.txtkepengurusan.setText("Kepenguusan Ekstrakulikuler"+ " " + namaE);

        NamaE = namaE;
    }

    private void AllButton(String namaE) {

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.kontener1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.recListKetua.getVisibility() == View.GONE){
                    binding.recListKetua.setVisibility(View.VISIBLE);
                    binding.rowright1.animate().rotation(binding.rowright1.getRotation()+90).start();
                }
                else{
                    binding.recListKetua.setVisibility(View.GONE);
                    binding.rowright1.animate().rotation(binding.rowright1.getRotation()-90).start();
                }

            }
        });

        binding.kontener2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.recListWakil.getVisibility() == View.GONE){
                    binding.recListWakil.setVisibility(View.VISIBLE);
                    binding.rowright2.animate().rotation(binding.rowright2.getRotation()+90).start();
                }
                else{
                    binding.recListWakil.setVisibility(View.GONE);
                    binding.rowright2.animate().rotation(binding.rowright2.getRotation()-90).start();
                }
            }
        });

        binding.kontener3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.recListSekretaris.getVisibility() == View.GONE){
                    binding.recListSekretaris.setVisibility(View.VISIBLE);
                    binding.rowright3.animate().rotation(binding.rowright3.getRotation()+90).start();
                }
                else{
                    binding.recListSekretaris.setVisibility(View.GONE);
                    binding.rowright3.animate().rotation(binding.rowright3.getRotation()-90).start();
                }
            }
        });

        binding.kontener4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.recListBendahara.getVisibility() == View.GONE){
                    binding.recListBendahara.setVisibility(View.VISIBLE);
                    binding.rowright4.animate().rotation(binding.rowright4.getRotation()+90).start();
                }
                else{
                    binding.recListBendahara.setVisibility(View.GONE);
                    binding.rowright4.animate().rotation(binding.rowright4.getRotation()-90).start();
                }
            }
        });

        binding.kontener5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.recListAbsensi.getVisibility() == View.GONE){
                    binding.recListAbsensi.setVisibility(View.VISIBLE);
                    binding.rowright5.animate().rotation(binding.rowright5.getRotation()+90).start();
                }
                else{
                    binding.recListAbsensi.setVisibility(View.GONE);
                    binding.rowright5.animate().rotation(binding.rowright5.getRotation()-90).start();
                }
            }
        });

        binding.kontener6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.recListAnggota.getVisibility() == View.GONE){
                    binding.recListAnggota.setVisibility(View.VISIBLE);
                    binding.rowright6.animate().rotation(binding.rowright6.getRotation()+90).start();
                }
                else{
                    binding.recListAnggota.setVisibility(View.GONE);
                    binding.rowright6.animate().rotation(binding.rowright6.getRotation()-90).start();
                }
            }
        });

    }

    @Override
    public void showDataUser(List<ModelGetEkskul> modelGetUser) {
        binding.recListKetua.setAdapter(new AdapterListEkskul(getApplicationContext(), modelGetUser, this));
        binding.recListKetua.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDataUser2(List<ModelGetEkskul> modelGetUser) {
        binding.recListWakil.setAdapter(new AdapterListEkskul(getApplicationContext(), modelGetUser, this));
        binding.recListWakil.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showDataUser3(List<ModelGetEkskul> modelGetUser) {
        binding.recListSekretaris.setAdapter(new AdapterListEkskul(getApplicationContext(), modelGetUser,this));
        binding.recListSekretaris.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showDataUser4(List<ModelGetEkskul> modelGetUser) {
        binding.recListBendahara.setAdapter(new AdapterListEkskul(getApplicationContext(), modelGetUser, this));
        binding.recListBendahara.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showDataUser5(List<ModelGetEkskul> modelGetUser) {
        binding.recListAbsensi.setAdapter(new AdapterListEkskul(getApplicationContext(), modelGetUser, this));
        binding.recListAbsensi.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showDataUser6(List<ModelGetEkskul> modelGetUser) {
        binding.recListAnggota.setAdapter(new AdapterListEkskul(getApplicationContext(), modelGetUser, this));
        binding.recListAnggota.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onItemClick(int position, List<ModelGetEkskul> modelUserEks) {
        ModelGetEkskul modelReq = modelUserEks.get(position);
        Intent intent = new Intent(StukturOrganisasi.this, DetailUserEkskul.class);
        intent.putExtra(EXTRA_ID, modelReq.getId_ek());
        intent.putExtra(EXTRA_UID, modelReq.getUid());
        intent.putExtra(EXTRA_NAMA, modelReq.getNama_user());
        intent.putExtra(EXTRA_IMG, modelReq.getImg_user());
        intent.putExtra(EXTRA_NIS, modelReq.getNis());
        intent.putExtra(EXTRA_ALAMAT, modelReq.getAlamat());
        intent.putExtra(EXTRA_KLS, modelReq.getKelas());
        intent.putExtra(EXTRA_JK, modelReq.getJk());
        intent.putExtra(EXTRA_NOHP, modelReq.getNohp());
        intent.putExtra(EXTRA_STATUS, modelReq.getStatus());
        intent.putExtra(EXTRA_NAMA_EKSKUL, NamaE);
        startActivity(intent);
    }
}