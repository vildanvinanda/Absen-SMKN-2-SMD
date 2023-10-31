package com.example.belajarretrofit.Model.Ekskul;

public class ModelEkskul {

    String id_ekskul, nama, deskripsi, img, ketua, wakil, sekretaris, bendahara, jml_anggota;

    public void ModelEkskul(String id_ekskul, String nama, String deskripsi, String img, String ketua, String wakil, String sekretaris, String bendahara, String jml_anggota) {
        this.id_ekskul = id_ekskul;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.img = img;
        this.ketua = ketua;
        this.wakil = wakil;
        this.sekretaris = sekretaris;
        this.bendahara = bendahara;
        this.jml_anggota = jml_anggota;
    }

    public String getJml_anggota() {
        return jml_anggota;
    }

    public void setJml_anggota(String jml_anggota) {
        this.jml_anggota = jml_anggota;
    }

    public String getKetua() {
        return ketua;
    }

    public void setKetua(String ketua) {
        this.ketua = ketua;
    }

    public String getWakil() {
        return wakil;
    }

    public void setWakil(String wakil) {
        this.wakil = wakil;
    }

    public String getSekretaris() {
        return sekretaris;
    }

    public void setSekretaris(String sekretaris) {
        this.sekretaris = sekretaris;
    }

    public String getBendahara() {
        return bendahara;
    }

    public void setBendahara(String bendahara) {
        this.bendahara = bendahara;
    }

    public String getId_ekskul() {
        return id_ekskul;
    }

    public void setId_ekskul(String id_ekskul) {
        this.id_ekskul = id_ekskul;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
