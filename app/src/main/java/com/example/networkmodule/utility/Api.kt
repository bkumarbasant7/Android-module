package com.example.networkmodule.utility

import android.icu.util.TimeUnit
import androidx.viewbinding.BuildConfig
import com.example.networkmodule.BuildConfig.API_BASE_URL
import com.google.gson.*
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.xml.datatype.DatatypeConstants.SECONDS


interface Api {
    companion object Factory {
        fun create(): Api {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_BASE_URL)
                .build()
            return retrofit.create(Api::class.java)
        }
    }



    @GET("marvel")
   suspend fun getsuperHeroes(): Response<List<String?>?>?
}
private val okClient = OkHttpClient().newBuilder()
    .connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
    .readTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
    .writeTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
    .build()

//    .addNetworkInterceptor(ChuckInterceptor(InstaApi.App.appContext))


var gson = GsonBuilder().registerTypeAdapter(Double::class.java, object :
    JsonSerializer<Double?> {
    override fun serialize(
        src: Double?,
        typeOfSrc: java.lang.reflect.Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return if (src == src!!.toLong().toDouble()) JsonPrimitive(src.toLong()) else JsonPrimitive(
            src
        )
    }
}).create()

val webservice by lazy {
    Retrofit.Builder()
        .client(okClient)
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build().create(Api::class.java)
}
