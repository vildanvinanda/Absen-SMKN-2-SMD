package com.example.belajarretrofit.Model.EkUser;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelStatus{

	@SerializedName("ModelStatus")
	private List<ModelStatusItem> modelStatus;

	public void setModelStatus(List<ModelStatusItem> modelStatus){
		this.modelStatus = modelStatus;
	}

	public List<ModelStatusItem> getModelStatus(){
		return modelStatus;
	}
}