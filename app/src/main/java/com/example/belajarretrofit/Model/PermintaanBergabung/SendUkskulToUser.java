package com.example.belajarretrofit.Model.PermintaanBergabung;

import com.google.gson.annotations.SerializedName;

public class SendUkskulToUser{

	@SerializedName("message")
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}