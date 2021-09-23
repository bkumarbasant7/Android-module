package com.example.networkmodule.utility

import android.app.Application

class InstaApi private constructor(){
    private object HOLDER {
        val INSTANCE = InstaApi()
    }
    private lateinit var app: Application


    /**
     *mandatory function
     *
     * **/

    public fun initializeApis(applicationContext: Application){
        app=applicationContext
        initializeStetho(app)
    }

    public fun getApp():Application{
        return app
    }

    private fun initializeStetho(applicationContext: Application){
//        Stetho.initializeWithDefaults(applicationContext)
//        AndroidThreeTen.init(applicationContext)

    }
    companion object {
        val instance: InstaApi by lazy { HOLDER.INSTANCE }
    }


}
