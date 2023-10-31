package com.example.belajarretrofit.Model;

public class ModelRiwayat {
    String jdl,tgl;

    public ModelRiwayat(String jdl, String tgl) {
        this.jdl = jdl;
        this.tgl = tgl;
    }

    public String getJdl() {
        return jdl;
    }

    public void setJdl(String jdl) {
        this.jdl = jdl;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
}
