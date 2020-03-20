package com.example.dremobil.ui.delogare;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DelogareViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public DelogareViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
