package com.example.belajarretrofit.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ImageViewModel extends ViewModel {

    private MutableLiveData<String> imageUrlLiveData = new MutableLiveData<>();

    public LiveData<String> getImageUrlLiveData() {
        return imageUrlLiveData;
    }

    public void setImageUrl(String imageUrl) {
        imageUrlLiveData.setValue(imageUrl);
    }
}
