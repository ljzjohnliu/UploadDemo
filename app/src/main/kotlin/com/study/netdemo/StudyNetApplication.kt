package com.study.netdemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

open class StudyNetApplication: Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        protected var sInstance: Context? = null

        fun getInstance(): Context? {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        sInstance = base
    }

}