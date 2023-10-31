package com.example.belajarretrofit.Model.login;

import com.google.gson.annotations.SerializedName;

public class Logindata{

	@SerializedName("img_user")
	private String imgUser;

	@SerializedName("uid")
	private String uid;

	@SerializedName("jk")
	private String jk;

	@SerializedName("nama")
	private String nama;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("type_user")
	private String typeUser;

	@SerializedName("nis")
	private String nis;

	@SerializedName("email")
	private String email;

	@SerializedName("alamat")
	private String alamat;

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

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

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setTypeUser(String typeUser){
		this.typeUser = typeUser;
	}

	public String getTypeUser(){
		return typeUser;
	}

	public void setNis(String nis){
		this.nis = nis;
	}

	public String getNis(){
		return nis;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}
}