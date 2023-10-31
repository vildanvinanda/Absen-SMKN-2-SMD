package com.example.belajarretrofit.Model.riwayat;

import com.google.gson.annotations.SerializedName;

public class ModelRiwayat {

	@SerializedName("dataRiwayat")
	private DataRiwayat dataRiwayat;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDataRiwayat(DataRiwayat dataRiwayat){
		this.dataRiwayat = dataRiwayat;
	}

	public DataRiwayat getDataRiwayat(){
		return dataRiwayat;
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