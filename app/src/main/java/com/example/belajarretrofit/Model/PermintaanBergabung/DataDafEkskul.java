package com.example.belajarretrofit.Model.PermintaanBergabung;

import com.google.gson.annotations.SerializedName;

public class DataDafEkskul{

	@SerializedName("img_user")
	private String imgUser;

	@SerializedName("uid")
	private String uid;

	@SerializedName("jk")
	private String jk;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("nis")
	private String nis;

	@SerializedName("nohp")
	private String nohp;

	@SerializedName("nama_user")
	private String namaUser;

	@SerializedName("id_ek")
	private String idEk;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("status")
	private String status;

	public void setImgUser(String imgUser){
		this.imgUser = imgUser;
	}

	public String getImgUser(){
		return imgUser;
	}

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

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
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

	public void setNamaUser(String namaUser){
		this.namaUser = namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	public void setIdEk(String idEk){
		this.idEk = idEk;
	}

	public String getIdEk(){
		return idEk;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}