package com.example.belajarretrofit.Model.jadwal;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelJadwal{



	@SerializedName("dataJadwal")
	private DataJadwal dataJadwal;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDataJadwal(DataJadwal dataJadwal){
		this.dataJadwal = dataJadwal;
	}

	public DataJadwal getDataJadwal(){
		return dataJadwal;
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