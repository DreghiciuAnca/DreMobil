package com.example.dremobil.ui.detalii_cont;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreareContViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CreareContViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
