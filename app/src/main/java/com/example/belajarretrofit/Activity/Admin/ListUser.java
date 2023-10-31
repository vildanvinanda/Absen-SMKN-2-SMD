package com.example.belajarretrofit.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.example.belajarretrofit.Adapter.AdapterGetAllUser;
import com.example.belajarretrofit.Model.User.ModelUserPlusJML;
import com.example.belajarretrofit.Presenter.ListUserPresenter;
import com.example.belajarretrofit.View.ListUserInterface;
import com.example.belajarretrofit.databinding.ActivityListUserBinding;

import java.util.List;

public class ListUser extends AppCompatActivity implements ListUserInterface {

    private ActivityListUserBinding binding;
    ListUserPresenter presenter;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        presenter = new ListUserPresenter(this);
        presenter.getAllUser();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.kolomsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence keyword, int start, int before, int count) {
//                Toast.makeText(ListEksktrakulikuler.this, "Proses pencarian", Toast.LENGTH_SHORT).show();

                if (keyword.toString()!=null)
                {
                    presenter.getDataFilter(keyword.toString());
                }
                else
                {
                    presenter.getAllUser();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void onSuccess(List<ModelUserPlusJML> message, String jml) {
        Log.d("JML_TAG", "Nilai jml: " + jml);
        binding.addjml.setText(jml);
        binding.recListAllUser.setAdapter(new AdapterGetAllUser(getApplicationContext(),message));
        binding.recListAllUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
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
    public void onFailure(String message) {

    }

    @Override
    public void onError(String localizedMessage) {

    }
}