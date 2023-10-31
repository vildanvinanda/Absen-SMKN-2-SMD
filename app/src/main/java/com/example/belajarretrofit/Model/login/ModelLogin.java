package com.example.belajarretrofit.Model.login;

import com.google.gson.annotations.SerializedName;

public class ModelLogin{

	@SerializedName("message")
	private String message;

	@SerializedName("logindata")
	private Logindata logindata;

	@SerializedName("status")
	private boolean status;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setLogindata(Logindata logindata){
		this.logindata = logindata;
	}

	public Logindata getLogindata(){
		return logindata;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}