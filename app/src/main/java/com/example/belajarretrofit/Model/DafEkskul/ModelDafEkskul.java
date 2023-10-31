package com.example.belajarretrofit.Model.DafEkskul;

import com.google.gson.annotations.SerializedName;

public class ModelDafEkskul{

	@SerializedName("dataDafEkskul")
	private DataDafEkskul dataDafEkskul;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDataDafEkskul(DataDafEkskul dataDafEkskul){
		this.dataDafEkskul = dataDafEkskul;
	}

	public DataDafEkskul getDataDafEkskul(){
		return dataDafEkskul;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}