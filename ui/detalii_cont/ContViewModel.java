package com.example.dremobil.ui.detalii_cont;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ContViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
