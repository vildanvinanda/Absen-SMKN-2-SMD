package com.example.belajarretrofit.Model.ModelAbsen;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelAbsenUser{

	@SerializedName("ModelAbsenUser")
	private List<ModelAbsenUserItem> modelAbsenUser;

	public void setModelAbsenUser(List<ModelAbsenUserItem> modelAbsenUser){
		this.modelAbsenUser = modelAbsenUser;
	}

	public List<ModelAbsenUserItem> getModelAbsenUser(){
		return modelAbsenUser;
	}
}