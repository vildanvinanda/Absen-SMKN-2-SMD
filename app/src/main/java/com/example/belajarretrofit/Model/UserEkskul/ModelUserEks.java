package com.example.belajarretrofit.Model.UserEkskul;

public class ModelUserEks {

    String id_ek, uid, nama_user, nis, jk, kelas, alamat, status, img_user;

    public ModelUserEks(String id_ek, String uid, String nama_user, String nis, String jk, String kelas, String alamat, String status, String img_user) {
        this.id_ek = id_ek;
        this.uid = uid;
        this.nama_user = nama_user;
        this.nis = nis;
        this.jk = jk;
        this.kelas = kelas;
        this.alamat = alamat;
        this.status = status;
        this.img_user = img_user;
    }

    public String getId_ek() {
        return id_ek;
    }

    public void setId_ek(String id_ek) {
        this.id_ek = id_ek;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg_user() {
        return img_user;
    }

    public void setImg_user(String img_user) {
        this.img_user = img_user;
    }
}
