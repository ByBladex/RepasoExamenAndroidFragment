package com.example.repasoexamenandroid.ui.insertar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InsertarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InsertarViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}