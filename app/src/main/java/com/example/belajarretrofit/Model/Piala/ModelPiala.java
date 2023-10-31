package com.example.belajarretrofit.Model.Piala;

public class ModelPiala {

    String id_piala, judul, des, tgl, img;

    public ModelPiala(String id_piala, String judul, String des, String tgl, String img) {
        this.id_piala = id_piala;
        this.judul = judul;
        this.des = des;
        this.tgl = tgl;
        this.img = img;
    }

    public String getId_piala() {
        return id_piala;
    }

    public void setId_piala(String id_piala) {
        this.id_piala = id_piala;
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
