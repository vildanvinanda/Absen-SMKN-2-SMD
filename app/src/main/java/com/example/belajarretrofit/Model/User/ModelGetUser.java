package com.example.belajarretrofit.Model.User;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelGetUser{

	@SerializedName("ModelGetUser")
	private ModelGetUserItem modelGetUser;

	public void setModelGetUser(ModelGetUserItem modelGetUser){
		this.modelGetUser = modelGetUser;
	}

	public ModelGetUserItem getModelGetUser(){
		return modelGetUser;
	}
}