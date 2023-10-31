package com.example.belajarretrofit.Model.jadwal;

import com.example.belajarretrofit.Model.Event;

import java.time.LocalDate;
import java.util.ArrayList;

public class JadwalModel {





    String id, judul, jam, tempat, hari, nama_ekskul, tgl, waktu;

    public JadwalModel(String id, String judul, String jam, String tempat, String hari, String nama_ekskul, String tgl, String waktu) {
        this.id = id;
        this.judul = judul;
        this.jam = jam;
        this.tempat = tempat;
        this.hari = hari;
        this.nama_ekskul = nama_ekskul;
        this.tgl = tgl;
        this.waktu = waktu;

    }

    public JadwalModel() {

    }

//    public static ArrayList<JadwalModel> eventsList = new ArrayList<>();
//
//    public static ArrayList<JadwalModel> eventsForDate(LocalDate date)
//    {
//        ArrayList<JadwalModel> events = new ArrayList<>();
//
//        for(JadwalModel event : eventsList)
//        {
//            if(event.getTgl().equals(date))
//                events.add(event);
//        }
//
//        return events;
//    }

//    public static ArrayList<JadwalModel> getEventsList() {
//        return eventsList;
//    }
//
//    public static void setEventsList(ArrayList<JadwalModel> eventsList) {
//        JadwalModel.eventsList = eventsList;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getNama_ekskul() {
        return nama_ekskul;
    }

    public void setNama_ekskul(String nama_ekskul) {
        this.nama_ekskul = nama_ekskul;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
