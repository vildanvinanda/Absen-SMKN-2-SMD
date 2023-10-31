package com.example.belajarretrofit.Model.riwayat;

import com.google.gson.annotations.SerializedName;

public class DataRiwayat{

	@SerializedName("uid")
	private String uid;

	@SerializedName("tgl")
	private String tgl;

	@SerializedName("id")
	private String id;

	@SerializedName("judul")
	private String judul;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
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
}