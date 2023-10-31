package com.example.belajarretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.ASuperUser.BuatAbsen;
import com.example.belajarretrofit.Activity.ASuperUser.ForUpdateEkskul;
import com.example.belajarretrofit.Activity.AUser.FormPendaftaran;
import com.example.belajarretrofit.Presenter.ListEkskulPresenter;
import com.example.belajarretrofit.View.SpesificEkskulInterface;
import com.example.belajarretrofit.databinding.ActivityDetailExtrakulikulerBinding;

import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_BENDAHARA;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_DESKRIPSI;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_ID;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_IMG;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_JML;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_KETUA;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_NAMA;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_SEKRETARIS;
import static com.example.belajarretrofit.Adapter.AdapterEkskul.EXTRA_WAKIL;

public class DetailExtrakulikuler extends AppCompatActivity implements SpesificEkskulInterface {

//    private FormPendaftaranPresenter presenter;
    private ListEkskulPresenter presenter;
    private ActivityDetailExtrakulikulerBinding binding;
    SessionManager sessionManager;
    String statuseks;
    public static final String EXTRA_NAME = "nama";
    public static final String EXTRA_DES = "deskripsi";
    public static final String EXTRA_IMG = "img";
    public static final String EXTRA_IDEKS = "id_ekskul";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailExtrakulikulerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        String cek = getArguments().getString("id_ek");
//        getData4(cek);
        Intent intent = getIntent();
        String id = intent.getStringExtra(EXTRA_ID);
        String nama = intent.getStringExtra(EXTRA_NAMA);
        String des = intent.getStringExtra(EXTRA_DESKRIPSI);
        String img = intent.getStringExtra(EXTRA_IMG);
        String ketua = intent.getStringExtra(EXTRA_KETUA);
        String wakil = intent.getStringExtra(EXTRA_WAKIL);
        String sekretaris = intent.getStringExtra(EXTRA_SEKRETARIS);
        String bendahara = intent.getStringExtra(EXTRA_BENDAHARA);
        String jml = intent.getStringExtra(EXTRA_JML);
//        String status = intent.getStringExtra(EXTRA_STATUS);

        sessionManager = new SessionManager(DetailExtrakulikuler.this);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        presenter = new ListEkskulPresenter(this);
        presenter.getSpesificEkskul(nama,uid);

        //jika dia itu sper user dan status dia bukan anggota maka dia akan 



        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DetailExtrakulikuler.this, ForUpdateEkskul.class);
                intent2.putExtra(EXTRA_NAME,nama);
                intent2.putExtra(EXTRA_DES,des);
                intent2.putExtra(EXTRA_IMG,img);
                intent2.putExtra(EXTRA_IDEKS,id);
                startActivity(intent2);
            }
        });

        binding.isiketua.setText(ketua);
        binding.isiwakil.setText(wakil);
        binding.isisekretaris.setText(sekretaris);
        binding.isibendahara.setText(bendahara);
        binding.txtisi.setText(des);
        binding.txtjdl.setText(nama);
        binding.jml.setText(jml);
        Glide.with(binding.imgEks).load(img).centerCrop().placeholder(R.drawable.ic_image).into(binding.imgEks);

        binding.btnabsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getnama = binding.txtjdl.getText().toString();
                Intent intent1 = new Intent(DetailExtrakulikuler.this, BuatAbsen.class);
                intent1.putExtra(EXTRA_NAME,getnama);
                startActivity(intent1);
            }
        });
        binding.btngabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailExtrakulikuler.this, FormPendaftaran.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void result(String status) {
//        Toast.makeText(this, model, Toast.LENGTH_SHORT).show();
        sessionManager = new SessionManager(DetailExtrakulikuler.this);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
//        String statuseks = status;
//        Toast.makeText(this, (CharSequence) status, Toast.LENGTH_SHORT).show();
        if (type.equals("super user")){
            if(status.equals("Anggota")){
                binding.btngabung.setVisibility(View.VISIBLE);
                binding.tamplatetbl.setVisibility(View.GONE);
                binding.txtjml.setText(status);
            } else {
                binding.btngabung.setVisibility(View.GONE);
                binding.tamplatetbl.setVisibility(View.VISIBLE);
            }
        } else {
            binding.btngabung.setVisibility(View.VISIBLE);
            binding.tamplatetbl.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String eror) {
        Toast.makeText(this, eror, Toast.LENGTH_LONG).show();
    }
}