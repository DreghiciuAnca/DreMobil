package com.example.dremobil.ui.cautare_service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CautareServiceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CautareServiceViewModel() {
        mText = new MutableLiveData<>();

    }
    public LiveData<String> getText() {
        return mText;
    }
}
