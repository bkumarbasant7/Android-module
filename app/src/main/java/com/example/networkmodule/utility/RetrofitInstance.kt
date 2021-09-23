package com.example.networkmodule.utility

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit




class RetrofitClient {
    private var instance: RetrofitClient? = null
    private var myApi: Api? = null

//    private fun RetrofitClient():RetrofitClient {
//        val retrofit: Retrofit = Retrofit.Builder().baseUrl("")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        myApi = retrofit.create(Api::class.java)
//    }

    @Synchronized
    fun getInstance(): RetrofitClient? {
        if (instance == null) {
            instance = RetrofitClient()
        }
        return instance
    }

    fun getMyApi(): Api? {
        return myApi
    }

}