package com.example.dremobil.ui.cos_cumparaturi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CosCumparaturiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CosCumparaturiViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
