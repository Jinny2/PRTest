package com.example.prTest.app

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Base64
import android.util.Log
import androidx.annotation.RequiresApi
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp
import java.security.MessageDigest

@HiltAndroidApp
class MainApplication : Application() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(applicationContext, "9430be375744b4c5801e93b81ebe12f0")
        getHashKey(applicationContext)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun getHashKey(context: Context) {
        try {
            val information = context.packageManager.getPackageInfo(
                context.packageName, PackageManager.GET_SIGNING_CERTIFICATES
            )
            val signatures = information.signingInfo.apkContentsSigners
            for (signature in signatures) {
                val md = MessageDigest.getInstance("SHA").apply {
                    update(signature.toByteArray())
                }
                val hc = String(Base64.encode(md.digest(), 0))

                Log.d("debugLog", "hashKey -> $hc")
            }
        } catch (e: Exception) {
            Log.d("debugLog", " exception -> $e")
        }
    }
}
