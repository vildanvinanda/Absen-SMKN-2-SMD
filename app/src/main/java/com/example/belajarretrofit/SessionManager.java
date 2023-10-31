package com.example.belajarretrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.belajarretrofit.Model.User.ModelImgPP;
import com.example.belajarretrofit.Model.User.ModelPP;
import com.example.belajarretrofit.Model.login.Logindata;

import java.util.HashMap;
import java.util.function.Predicate;

import okhttp3.MultipartBody;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    //ini data yang disimpan di session
    public static final String IS_LOGIN = "isLogin";
    public static final String UID = "uid";
    public static final String NIS = "nis";
    public static final String EMAIL = "email";
    public static final String NAMA = "nama";
    public static final String KELAS = "kelas";
    public static final String JK = "jk";
    public static final String ALAMAT = "alamat";
    public static final String NO_HP = "no_hp";
    public static final String TYPE_USER = "type_user";
    public static final String IMG_USER = "img_user";


    //membuat kela konstraktor disini kita
    //disini dimana sih kita ngambil sesinya
    public SessionManager(Context context) {
        this._context = context;
        //gunakan fungsi sharedReference yang namanya context
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        //baru editor bisa menggunakan session, ini tuh kita baru membuat objek aja biar bisa dipanggil
        editor = sharedPreferences.edit();
    }

    //disini kenapa login data ? karena data yang akan di simpan ada di  LoginData
    public void createLoginSession(Logindata user) {

        // Ambil URL gambar dari respons JSON
        String imgUrl = user.getImgUser();

// Decode URL dengan mengganti "\/" menjadi "/"
        imgUrl = imgUrl.replace("\\/", "/");

        //pas kita klik login kita akan membuat login session
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(UID, user.getUid());
        editor.putString(NIS, user.getNis());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(NAMA, user.getNama());
        editor.putString(KELAS, user.getKelas());
        editor.putString(JK, user.getJk());
        editor.putString(ALAMAT, user.getAlamat());
        editor.putString(NO_HP, user.getNoHp());
        editor.putString(TYPE_USER, user.getTypeUser());
        editor.putString(IMG_USER, imgUrl);
        editor.commit();
    }

    //cara memanggil data dari sesi ini
    public HashMap <String, String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        //kita kasih key uid dll lalu kita panggil sharedreference tadi, di dalam get string
        // ada user id dan defaulte idnya itu null atau tidak  ada
        user.put(UID, sharedPreferences.getString(UID, null));
        user.put(NIS, sharedPreferences.getString(NIS, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(KELAS, sharedPreferences.getString(KELAS, null));
        user.put(JK, sharedPreferences.getString(JK, null));
        user.put(ALAMAT, sharedPreferences.getString(ALAMAT, null));
        user.put(NO_HP, sharedPreferences.getString(NO_HP, null));
        user.put(TYPE_USER, sharedPreferences.getString(TYPE_USER, null));
        user.put(IMG_USER, sharedPreferences.getString(IMG_USER, null));
        //kita  kembaliakan datanya
        return user;
    }


    //buat sesi  loggout
    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    //fungsi yang berguna untuk membuat user tidak masuk lagi ke dalam login activity seblum di logout
    public boolean isLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void updateUserData(String s, String nama, String kls, String alamat, String jk, String message) {
        // Simpan data pengguna yang diperbarui ke dalam sesi
        editor.putString(NAMA, nama);
        editor.putString(KELAS, kls);
        editor.putString(JK, jk);
        editor.putString(ALAMAT, alamat);
        editor.putString(NO_HP, s);
        editor.apply();
    }

    public void updateNamaUserData(String addname) {
//        editor.putString(NAMA, user);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAMA,addname);
        editor.commit();
    }

    public void updateAlamatUserData(String alamat) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ALAMAT,alamat);
        editor.commit();
    }

    public void updateKelasUserData(String kls) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KELAS,kls);
        editor.commit();
    }

    public void updateG2UserData(String g2) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(JK,g2);
        editor.commit();
    }

    public void updateG1UserData(String g1) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(JK,g1);
        editor.commit();
    }

    public void updateNomorUserData(String addnomor) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NO_HP,addnomor);
        editor.commit();
    }

    public void updateImgUserData(MultipartBody.Part body) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IMG_USER, String.valueOf(body));
        editor.commit();
    }

    public void updateImageUserData(String imageUrl) {
//        String imgUrl = img;
        SharedPreferences.Editor editor = sharedPreferences.edit();
// Decode URL dengan mengganti "\/" menjadi "/"
//        imgUrl = imgUrl.replace("\\/", "/");

        //pas kita klik login kita akan membuat login session
        editor.putString(IMG_USER, imageUrl);
        editor.commit();
    }
}
