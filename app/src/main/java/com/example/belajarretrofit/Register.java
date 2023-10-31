package com.example.belajarretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.Activity.Login;
import com.example.belajarretrofit.View.RegisterView;
import com.example.belajarretrofit.Presenter.RegisterPresenter;
import com.example.belajarretrofit.databinding.ActivityRegisterBinding;

import java.util.ArrayList;

public class Register extends AppCompatActivity implements RegisterView {

    ArrayList<String> spinnerList, spinnerList2;
    ArrayAdapter<String> adapter, adapter2;
    RegisterPresenter registerPresenter;
    ApiInterface apiInterface;
    private ActivityRegisterBinding binding;
    String item;
    String[] kelas = {"Pilih Kelas", "X", "XI", "XII"};

    String item2;
    String[] jurusan = {"Pilih Jurusan", "RPL", "TKRO", "TBSM", "TPTL", "TKJ", "OTOTRONIK"};

    RadioButton radioButton;

    ProgressDialog dialog;
    boolean addpassVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spinnerList = new ArrayList<>();
        spinnerList2 = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,kelas);
        adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item,jurusan);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        adapter2.setDropDownViewResource(R.layout.spinner_item);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        binding.addkelas.setAdapter(adapter);
        binding.addjurusan.setAdapter(adapter2);

        registerPresenter = new RegisterPresenter(this);

    }


    public void btnRegister(View view) {
        validasi();
    }

    private void validasi() {
        String userF = binding.adduserFirst.getText().toString();
        String userE = binding.adduserEnd.getText().toString();
        String nis = binding.addnis.getText().toString();
        String email = binding.addemail.getText().toString();
        String password = binding.addpass.getText().toString();
        String verif = binding.addverifpass.getText().toString();
        String alamat = binding.addalamat.getText().toString();
        String no_hp = binding.addnomor.getText().toString();
        String jurusan = binding.addjurusan.getSelectedItem().toString();
        String kls = binding.addkelas.getSelectedItem().toString();
        String verifpassword = binding.addverifpass.getText().toString().trim();

        if(TextUtils.isEmpty(userF)){
            binding.adduserFirst.setError("Tolong Diisi");
            binding.adduserFirst.requestFocus();
        } else if (TextUtils.isEmpty(nis)){
            binding.addnis.setError("Tolong Diisi");
            binding.addnis.requestFocus();
        }else if (nis.length() < 10){
            binding.addnis.setError("Wajib 10");
            binding.addnis.requestFocus();
        }else if (TextUtils.isEmpty(email)){
            binding.addemail.setError("Tolong Diisi");
            binding.addemail.requestFocus();
        }else if (binding.radiongrupGender.getCheckedRadioButtonId() == -1){
            binding.radiongrupGender.requestFocus();
        }else if (kelas.equals("Pilih Kelas")){
            binding.addkelas.requestFocus();
        }else if (jurusan.equals("Pilih Jurusan")){
            binding.addjurusan.requestFocus();
        } else if (TextUtils.isEmpty(no_hp)){
            binding.addnomor.setError("Tolong Diisi");
            binding.addnomor.requestFocus();
        } else if (no_hp.length() < 12){
            binding.addnomor.setError("Wajib 12");
            binding.addnomor.requestFocus();
        } else if (TextUtils.isEmpty(alamat)){
            binding.addalamat.setError("Tolong Diisi");
            binding.addalamat.requestFocus();
        } else if (TextUtils.isEmpty(password)){
            binding.addpass.setError("Tolong Diisi");
            binding.addpass.requestFocus();
        } else if (password.length() < 8){
            binding.addpass.setError("Wajib 8 karakter");
            binding.addpass.requestFocus();
        } else if (!password.equals(verifpassword)){
            binding.addverifpass.setError("Password tidak sesuai");
            binding.addverifpass.requestFocus();
        } else if (TextUtils.isEmpty(verifpassword)){
            binding.addverifpass.setError("Tolong Diisi");
            binding.addverifpass.requestFocus();
        } else {
            int idTerpilihH = binding.radiongrupGender.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(idTerpilihH);
            String jk = radioButton.getText().toString();
            String nama = userF+" "+userE;
            String kelas =kls +"-"+ jurusan;
            registerPresenter.CreateToServer(nis,email,password,nama,kelas,no_hp,jk,alamat);
        }
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void onSuccsess(String message) {
        Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(Register.this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

//    private void CreateToServer(String nis, String email, String password, String nama, String kelas, String no_hp, String jk, String alamat) {
//        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
//        dialog.show();
////        loginPresenter = RegisterPresenter.getClient().create(ILoginPresenter.class);
//        apiInterface = ApiService.getClient().create(ApiInterface.class);
//        Call<ModelRegister> loginCall = apiInterface.registerResponse("",nis,email,password, nama, kelas, no_hp, jk, alamat,"user","");
////        Call<ModelRegister> loginCall = apiInterface.loginResponse(email,password);
//        loginCall.enqueue(new Callback<ModelRegister>() {
//            @Override
//            public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {
//                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
//
//
//                    //Ini untuk pindah
//                    //ngambil data yang login. h
//                    dialog.dismiss();
//                    Intent intent = new Intent(Register.this, Login.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    dialog.dismiss();
//                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelRegister> call, Throwable t) {
//                dialog.dismiss();
//                Toast.makeText(Register.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


}