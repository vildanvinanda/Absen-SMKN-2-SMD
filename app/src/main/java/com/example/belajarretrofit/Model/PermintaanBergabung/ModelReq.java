package com.example.belajarretrofit.Model.PermintaanBergabung;

public class ModelReq {
    String id_daf_ek, uid, nama, nis, jk, kls, alamat, alasan, nohp, status, img_user, jml;

    public ModelReq(String id_daf_ek, String uid, String nama, String nis, String jk, String kls, String alamat, String alasan, String nohp, String status, String img_user, String jml) {
        this.id_daf_ek = id_daf_ek;
        this.uid = uid;
        this.nama = nama;
        this.nis = nis;
        this.jk = jk;
        this.kls = kls;
        this.alamat = alamat;
        this.alasan = alasan;
        this.nohp = nohp;
        this.status = status;
        this.img_user = img_user;
        this.jml = jml;
    }

    public String getId_daf_ek() {
        return id_daf_ek;
    }

    public void setId_daf_ek(String id_daf_ek) {
        this.id_daf_ek = id_daf_ek;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getJml() {
        return jml;
    }

    public void setJml(String jml) {
        this.jml = jml;
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

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getKls() {
        return kls;
    }

    public void setKls(String kls) {
        this.kls = kls;
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
