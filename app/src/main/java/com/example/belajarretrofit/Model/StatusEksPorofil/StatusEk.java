package com.example.belajarretrofit.Model.StatusEksPorofil;

import com.google.gson.annotations.SerializedName;

public class StatusEk{

	@SerializedName("status")
	private String status;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}