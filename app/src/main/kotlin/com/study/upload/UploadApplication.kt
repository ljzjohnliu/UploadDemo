package com.study.upload

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.pandora.common.env.Env
import com.pandora.common.env.config.Config
import com.pandora.common.env.config.Config.BIZ_TYPE_UPLOAD
import com.ss.bduploader.BDUploadLog
import com.ss.bduploader.BDUploadLog.LOG_DEBUG
import com.ss.bduploader.BDUploadUtil
import com.ss.bduploader.BuildConfig


open class UploadApplication: Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        protected var sInstance: Context? = null

        fun getInstance(): Context? {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()

        BDUploadLog.turnOn(LOG_DEBUG, 1);
        BDUploadUtil.setEnableNativeLog(true);

        Env.start(
            Config.Builder()
                .setApplicationContext(this)
                .setAppID("123")
                .setAppName("UploadDemo") // 合法版本号应大于、等于 3 位，如："1.3.2"
                .setAppVersion(BuildConfig.VERSION_NAME)
                .setAppChannel("channel name")
                .setBizType(BIZ_TYPE_UPLOAD)
                .build()
        )
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        sInstance = base
    }

}