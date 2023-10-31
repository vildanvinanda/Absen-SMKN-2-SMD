package com.example.belajarretrofit.Model.EkUser;

import com.google.gson.annotations.SerializedName;

public class ModelEkUser{

	@SerializedName("eksUser")
	private EksUser eksUser;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setEksUser(EksUser eksUser){
		this.eksUser = eksUser;
	}

	public EksUser getEksUser(){
		return eksUser;
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