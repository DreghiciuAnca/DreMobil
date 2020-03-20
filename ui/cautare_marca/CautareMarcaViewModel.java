package com.example.dremobil.ui.cautare_marca;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CautareMarcaViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public CautareMarcaViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;

    }
}
