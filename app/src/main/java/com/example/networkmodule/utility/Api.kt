package com.example.networkmodule.utility

import androidx.viewbinding.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET




interface Api {
    companion object Factory {
        fun create(): Api {
            val retrofit = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BuildConfig.API_BASE_URL)
                .build()

            return retrofit.create(Api::class.java)
        }
    }

    @GET("marvel")
   suspend fun getsuperHeroes(): Response<List<String?>?>?
}