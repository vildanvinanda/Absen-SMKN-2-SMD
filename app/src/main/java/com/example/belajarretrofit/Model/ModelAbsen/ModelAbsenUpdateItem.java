package com.example.belajarretrofit.Model.ModelAbsen;

import com.google.gson.annotations.SerializedName;

public class ModelAbsenUpdateItem{

	@SerializedName("uid")
	private String uid;

	@SerializedName("nama")
	private String nama;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("tgl")
	private String tgl;

	@SerializedName("nis")
	private String nis;

	@SerializedName("id")
	private String id;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setNis(String nis){
		this.nis = nis;
	}

	public String getNis(){
		return nis;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}