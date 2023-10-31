package com.example.belajarretrofit.Model.User;

public class ModelUserPlusJML {

    String uid, nis, email, password, nama, kelas, no_hp, jk, alamat, type_user, img_user, kolom1, kolom2, jml;

    public ModelUserPlusJML(String uid, String nis, String email, String password, String nama, String kelas, String no_hp, String jk, String alamat, String type_user, String img_user, String kolom1, String kolom2, String jml) {
        this.uid = uid;
        this.nis = nis;
        this.email = email;
        this.password = password;
        this.nama = nama;
        this.kelas = kelas;
        this.no_hp = no_hp;
        this.jk = jk;
        this.alamat = alamat;
        this.type_user = type_user;
        this.img_user = img_user;
        this.kolom1 = kolom1;
        this.kolom2 = kolom2;
        this.jml = jml;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public String getImg_user() {
        return img_user;
    }

    public void setImg_user(String img_user) {
        this.img_user = img_user;
    }

    public String getKolom1() {
        return kolom1;
    }

    public void setKolom1(String kolom1) {
        this.kolom1 = kolom1;
    }

    public String getKolom2() {
        return kolom2;
    }

    public void setKolom2(String kolom2) {
        this.kolom2 = kolom2;
    }

    public String getJml() {
        return jml;
    }

    public void setJml(String jml) {
        this.jml = jml;
    }
}
