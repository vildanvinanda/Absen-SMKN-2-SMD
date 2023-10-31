package com.example.belajarretrofit.Model.Galeri;

public class ModelGaleri {
    String id_galeri, judul, des, tgl, img;

    public ModelGaleri(String id_galeri, String judul, String des, String tgl, String img) {
        this.id_galeri = id_galeri;
        this.judul = judul;
        this.des = des;
        this.tgl = tgl;
        this.img = img;
    }

    public String getId_galeri() {
        return id_galeri;
    }

    public void setId_galeri(String id_galeri) {
        this.id_galeri = id_galeri;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}





