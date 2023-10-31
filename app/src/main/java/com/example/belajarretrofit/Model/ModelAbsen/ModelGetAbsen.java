package com.example.belajarretrofit.Model.ModelAbsen;

public class ModelGetAbsen {

    String id, tgl, uid, nama, nis, kelas;

    public ModelGetAbsen(String id, String tgl, String uid, String nama, String nis, String kelas) {
        this.id = id;
        this.tgl = tgl;
        this.uid = uid;
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
