package com.buidel.type.fast.the.eleventhxmlwallpaper
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils
import java.util.*
import okhttp3.*

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Callback
import okhttp3.Call
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Response
import java.io.IOException

object DataWallPaper {
    val localImageData = listOf(
        R.drawable.ic_378,
        R.drawable.ic_379,
        R.drawable.ic_380,
        R.drawable.ic_381,
        R.drawable.ic_382,
        R.drawable.ic_383,
        R.drawable.ic_384,
        R.drawable.ic_389,
        R.drawable.ic_388,
        R.drawable.ic_390,
        R.drawable.ic_391,
        R.drawable.ic_393,
        R.drawable.ic_394,
        R.drawable.ic_395,
        R.drawable.ic_396,
        R.drawable.ic_398,
        R.drawable.ic_399,
    )

    val localBannerImageData = listOf(
        R.drawable.ic_378,
        R.drawable.ic_379,
        R.drawable.ic_380,
        R.drawable.ic_381,
        R.drawable.ic_382,
        R.drawable.ic_383,
    )

    private val sharedPreferences by lazy {
        App.appContext.getSharedPreferences(
            "Animal",
            Context.MODE_PRIVATE
        )
    }
    var uu_animal = ""
        set(value) {
            sharedPreferences.edit().run {
                putString("uu_animal", value)
                commit()
            }
            field = value
        }
        get() = sharedPreferences.getString("uu_animal", "").toString()
    var animal_clock = ""
        set(value) {
            sharedPreferences.edit().run {
                putString("animal_clock", value)
                commit()
            }
            field = value
        }
        get() = sharedPreferences.getString("animal_clock", "").toString()
    var posInt = 0
        set(value) {
            sharedPreferences.edit().run {
                putInt("posInt", value)
                commit()
            }
            field = value
        }
        get() = sharedPreferences.getInt("posInt", 0)

    var imgType = false
        set(value) {
            sharedPreferences.edit().run {
                putBoolean("imgType", value)
                commit()
            }
            field = value
        }
        get() = sharedPreferences.getBoolean("imgType", false)

    fun getExWData(context: Context): Map<String, Any> {
        if(!WallPaperUtils.getComplex2(listOf("22", "33"), 23)){
           return mapOf()
        }
        return mapOf(
            "monterey" to generateUniqueIdentifier(),
            "author" to System.currentTimeMillis(),
            "mccarty" to Build.MODEL,
            "peppy" to "com.nature.scape.wallpaper.views.wonders",
            "wi" to Build.VERSION.RELEASE,
            "kermit" to "",
            "gabbro" to getAndroidId(context),
            "sloven" to "cyanate",
            "romano" to getAppVersion(context),
            "look" to getBrand(context)
        )
    }

    private fun generateUniqueIdentifier(): String = uu_animal.ifEmpty { UUID.randomUUID().toString() }

    private fun getAndroidId(context: Context): String =
        Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)

    private fun getAppVersion(context: Context): String {
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            "Version information not available"
        }
    }

    private fun getBrand(context: Context): String {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.networkOperator
    }





    fun getCloudNetWithOkHttp(url: String, map: Map<String, Any>, onSuccess: (response: String) -> Unit, onError: (error: String) -> Unit) {
        val httpClient = OkHttpClient()
        val httpUrlBuilder = url.toHttpUrlOrNull()?.newBuilder() ?: throw IllegalArgumentException("Invalid URL")

        map.forEach { (key, value) ->
            httpUrlBuilder.addQueryParameter(key, value.toString())
        }

        val httpUrl = httpUrlBuilder.build()

        val request = Request.Builder()
            .url(httpUrl)
            .build()

        httpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onError("Network error: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    onError("Server error: HTTP ${response.code}")
                } else {
                    response.body?.string()?.let {
                        onSuccess(it)
                    } ?: onError("No response from server")
                }
            }
        })
    }


}