package com.example.belajarretrofit.Model.ProfilSetting;

public class ModelFAQResponse {
    String fid, pertanyaan, jawaban;

    public ModelFAQResponse(String fid, String pertanyaan, String jawaban) {
        this.fid = fid;
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
