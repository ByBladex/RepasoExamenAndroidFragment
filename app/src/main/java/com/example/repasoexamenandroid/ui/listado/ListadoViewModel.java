package com.example.repasoexamenandroid.ui.listado;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListadoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListadoViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}