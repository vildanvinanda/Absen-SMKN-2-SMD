package com.example.belajarretrofit.Model.EkUser;

import com.google.gson.annotations.SerializedName;

public class EksUser{

	@SerializedName("uid")
	private String uid;

	@SerializedName("kolom2")
	private String kolom2;

	@SerializedName("kolom1")
	private String kolom1;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setKolom2(String kolom2){
		this.kolom2 = kolom2;
	}

	public String getKolom2(){
		return kolom2;
	}

	public void setKolom1(String kolom1){
		this.kolom1 = kolom1;
	}

	public String getKolom1(){
		return kolom1;
	}
}