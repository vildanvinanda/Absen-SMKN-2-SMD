package com.example.belajarretrofit.Model.Ekskul;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelSpesificEkskul{

	String status;

	public ModelSpesificEkskul(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}