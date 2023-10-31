package com.example.belajarretrofit.Model.DafEkskul;

import com.google.gson.annotations.SerializedName;

public class DataDafEkskul{

	@SerializedName("uid")
	private String uid;

	@SerializedName("jk")
	private String jk;

	@SerializedName("id_daf_ek")
	private String idDafEk;

	@SerializedName("kls")
	private String kls;

	@SerializedName("nama")
	private String nama;

	@SerializedName("nis")
	private String nis;

	@SerializedName("nohp")
	private String nohp;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("alasan")
	private String alasan;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setJk(String jk){
		this.jk = jk;
	}

	public String getJk(){
		return jk;
	}

	public void setIdDafEk(String idDafEk){
		this.idDafEk = idDafEk;
	}

	public String getIdDafEk(){
		return idDafEk;
	}

	public void setKls(String kls){
		this.kls = kls;
	}

	public String getKls(){
		return kls;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNis(String nis){
		this.nis = nis;
	}

	public String getNis(){
		return nis;
	}

	public void setNohp(String nohp){
		this.nohp = nohp;
	}

	public String getNohp(){
		return nohp;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setAlasan(String alasan){
		this.alasan = alasan;
	}

	public String getAlasan(){
		return alasan;
	}
}