package com.example.belajarretrofit.Model.User;

import com.google.gson.annotations.SerializedName;

public class ModelGetUserItem{

	@SerializedName("jk")
	private String jk;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("type_user")
	private String typeUser;

	@SerializedName("kolom2")
	private String kolom2;

	@SerializedName("kolom1")
	private String kolom1;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("img_user")
	private String imgUser;

	@SerializedName("uid")
	private String uid;

	@SerializedName("password")
	private String password;

	@SerializedName("nama")
	private String nama;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("nis")
	private String nis;

	@SerializedName("email")
	private String email;

	public void setJk(String jk){
		this.jk = jk;
	}

	public String getJk(){
		return jk;
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

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
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

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
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
}