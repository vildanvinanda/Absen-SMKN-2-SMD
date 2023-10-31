package com.example.belajarretrofit.Activity.ASuperUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.belajarretrofit.Presenter.ListStrukturEkskulPresenter;
import com.example.belajarretrofit.View.ListStrukturInterface;
import com.example.belajarretrofit.databinding.ActivityListStrukturEkstrakulikulerBinding;

public class ListStrukturEkstrakulikuler extends AppCompatActivity implements ListStrukturInterface {

    public static final String EXTRA_NAMAE = "ekskul";
    ListStrukturEkskulPresenter presenter;
    private ActivityListStrukturEkstrakulikulerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListStrukturEkstrakulikulerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ListStrukturEkskulPresenter(this);

        // Mulai tugas latar belakang menggunakan AsyncTask
        new BackgroundTask().execute();

//        String basket = binding.txtbakset.getText().toString();
//        String volley = binding.txtbakset.getText().toString();
//        String badminton = binding.txtbakset.getText().toString();
//        String sepakbola = binding.txtbakset.getText().toString();
//        String silat = binding.txtbakset.getText().toString();
//        String paskibra = binding.txtbakset.getText().toString();
//        presenter.getDataBasket(basket);
//        presenter.getDataPaskibra(paskibra);
//        presenter.getDataVolley(volley);
//        presenter.getDataBadminton(badminton);
//        presenter.getDataSepakdola(sepakbola);
//        presenter.getDataSilat(silat);



        AllButton();

    }

    private class BackgroundTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            // Lakukan pemrosesan latar belakang di sini
            String basket = binding.txtbakset.getText().toString();
            String volley = binding.txtpaskibra.getText().toString();
            String badminton = binding.txtbakset.getText().toString();
            String sepakbola = binding.txtbakset.getText().toString();
            String silat = binding.txtbakset.getText().toString();
            String paskibra = binding.txtbakset.getText().toString();

            presenter.getDataBasket(basket);
            presenter.getDataPaskibra(paskibra);
            presenter.getDataVolley(volley);
            presenter.getDataBadminton(badminton);
            presenter.getDataSepakdola(sepakbola);
            presenter.getDataSilat(silat);

            return null;
        }
    }

    private void AllButton() {
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.tamplateEksBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaE = "Basket";
                Intent intent = new Intent(ListStrukturEkstrakulikuler.this, StukturOrganisasi.class);
                intent.putExtra(EXTRA_NAMAE,namaE);
                startActivity(intent);
            }
        });
        binding.tamplateEksPaskibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaE = "Paskibra";
                Intent intent = new Intent(ListStrukturEkstrakulikuler.this, StukturOrganisasi.class);
                intent.putExtra(EXTRA_NAMAE,namaE);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showJmlBasket(String jml) {

        binding.jml1.setText(jml);
    }

    @Override
    public void showError(String localizedMessage) {
        Toast.makeText(this, localizedMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showJmlPaskibra(String jml) {
        binding.jml2.setText(jml);
    }
}