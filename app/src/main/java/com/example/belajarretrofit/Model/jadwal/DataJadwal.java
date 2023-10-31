package com.example.belajarretrofit.Model.jadwal;

import com.example.belajarretrofit.Model.Event;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DataJadwal{

//	public static ArrayList<ModelJadwal> eventsForDate(LocalDate date)
//	{
//		ArrayList<ModelJadwal> events = new ArrayList<>();
//
//		for(ModelJadwal event : eventsList)
//		{
//			if(event.getDataJadwal().getTgl().equals(date))
//				events.add(event);
//		}
//
//		return events;
//	}

	@SerializedName("hari")
	private String hari;

	@SerializedName("tempat")
	private String tempat;

	@SerializedName("jam")
	private String jam;

	@SerializedName("tgl")
	private LocalDate tgl;

	@SerializedName("waktu")
	private LocalTime waktu;

	@SerializedName("id")
	private String id;

	@SerializedName("judul")
	private String judul;

	@SerializedName("nama_ekskul")

	private String namaEkskul;

	public static ArrayList<ModelJadwal> eventsList = new ArrayList<>();
	public static ArrayList<ModelJadwal> eventsForDate(LocalDate selectedDate) {
		ArrayList<ModelJadwal> events = new ArrayList<>();

		for(ModelJadwal event : eventsList)
		{
			if(event.getDataJadwal().getTgl().equals(selectedDate))
				events.add(event);
		}

		return events;
	}

	public static ArrayList<ModelJadwal> getEventsList() {
		return eventsList;
	}

	public static void setEventsList(ArrayList<ModelJadwal> eventsList) {
		DataJadwal.eventsList = eventsList;
	}

	public void setHari(String hari){
		this.hari = hari;
	}

	public String getHari(){
		return hari;
	}

	public void setTempat(String tempat){
		this.tempat = tempat;
	}

	public String getTempat(){
		return tempat;
	}

	public void setJam(String jam){
		this.jam = jam;
	}

	public String getJam(){
		return jam;
	}

	public void setTgl(LocalDate tgl){
		this.tgl = tgl;
	}

	public LocalDate getTgl(){
		return tgl;
	}

	public void setWaktu(LocalTime waktu){
		this.waktu = waktu;
	}

	public LocalTime getWaktu(){
		return waktu;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setNamaEkskul(String namaEkskul){
		this.namaEkskul = namaEkskul;
	}

	public String getNamaEkskul(){
		return namaEkskul;
	}
}