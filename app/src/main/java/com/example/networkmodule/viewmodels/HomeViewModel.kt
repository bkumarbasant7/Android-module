package com.example.networkmodule.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val pageId: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun getCurrentPageId():LiveData<String>{
        return pageId
    }
    fun setPageId(id:String){
        pageId.postValue(id)
    }
}