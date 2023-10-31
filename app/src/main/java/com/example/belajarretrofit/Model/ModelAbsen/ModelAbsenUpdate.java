package com.example.belajarretrofit.Model.ModelAbsen;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelAbsenUpdate{

	@SerializedName("ModelAbsenUpdate")
	private List<ModelAbsenUpdateItem> modelAbsenUpdate;

	public void setModelAbsenUpdate(List<ModelAbsenUpdateItem> modelAbsenUpdate){
		this.modelAbsenUpdate = modelAbsenUpdate;
	}

	public List<ModelAbsenUpdateItem> getModelAbsenUpdate(){
		return modelAbsenUpdate;
	}
}