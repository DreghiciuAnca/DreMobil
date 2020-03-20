package com.example.dremobil.ui.piese;

import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dremobil.R;

public class PieseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PieseViewModel()
    {
        mText = new MutableLiveData<>();


    }
    public LiveData<String> getText() {
        return mText;
    }
}