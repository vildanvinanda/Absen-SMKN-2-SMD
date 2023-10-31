package com.example.belajarretrofit.Model.User;

import com.google.gson.annotations.SerializedName;

public class ModelPP{
	@SerializedName("status")
	private boolean status;

	@SerializedName("img_user")
	private String imageUrl;

	public boolean isStatus() {
		return status;
	}

	public String getImageUrl() {
		return imageUrl;
	}

}