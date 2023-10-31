package com.example.belajarretrofit.Model.EkUser;

import com.google.gson.annotations.SerializedName;

public class ModelStatusItem{

	@SerializedName("status")
	private String status;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}