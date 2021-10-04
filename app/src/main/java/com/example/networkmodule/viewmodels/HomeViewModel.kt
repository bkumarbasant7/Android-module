package com.example.networkmodule.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkmodule.utility.Api
import com.example.networkmodule.utility.webservice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
    fun getAllHeros(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try{
                    var response = webservice.getsuperHeroes()
                    if(response.isSuccessful){
                        Log.d("MARVEL HEROES","Success")

                    }else{
                        Log.d("MARVEL HEROES","FAILED")
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }

            }
        }
    }
    private val netowrkSwervice : Api = webservice
}