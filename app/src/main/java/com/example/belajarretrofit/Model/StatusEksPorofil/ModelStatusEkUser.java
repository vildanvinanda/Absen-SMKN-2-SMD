package com.example.belajarretrofit.Model.StatusEksPorofil;

import com.google.gson.annotations.SerializedName;

public class ModelStatusEkUser{

	@SerializedName("statusEk")
	private String statusEk;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public ModelStatusEkUser(String statusEk, String message, String status) {
		this.statusEk = statusEk;
		this.message = message;
		this.status = status;
	}

	public void setStatusEk(String statusEk){
		this.statusEk = statusEk;
	}

	public String getStatusEk(){
		return statusEk;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}