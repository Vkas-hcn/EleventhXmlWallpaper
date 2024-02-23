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
        R.drawable.ic_1,
        R.drawable.ic_2,
        R.drawable.ic_3,
        R.drawable.ic_4,
        R.drawable.ic_5,
        R.drawable.ic_6,
        R.drawable.ic_7,
        R.drawable.ic_8,
        R.drawable.ic_9,
        R.drawable.ic_10,
        R.drawable.ic_11,
        R.drawable.ic_12,
        R.drawable.ic_13,
        R.drawable.ic_14,
        R.drawable.ic_15,
        R.drawable.ic_16,
        R.drawable.ic_17,
        R.drawable.ic_18,
        R.drawable.ic_19,
        R.drawable.ic_20,
        R.drawable.ic_21,
        R.drawable.ic_22,
        R.drawable.ic_23,
        R.drawable.ic_24,
        R.drawable.ic_25,
        R.drawable.ic_26,
        R.drawable.ic_27,
        R.drawable.ic_28,
        R.drawable.ic_29,
        R.drawable.ic_30,
        R.drawable.ic_31,
        R.drawable.ic_32,
        R.drawable.ic_33,
        R.drawable.ic_34,
        R.drawable.ic_35,
        R.drawable.ic_36,
        R.drawable.ic_37,
        R.drawable.ic_38,
        R.drawable.ic_39,
        R.drawable.ic_40,
        R.drawable.ic_41,
        R.drawable.ic_42,
        R.drawable.ic_43,
        R.drawable.ic_44,
        R.drawable.ic_45,
        R.drawable.ic_46,
        R.drawable.ic_47,
        R.drawable.ic_48,
        R.drawable.ic_49,
        R.drawable.ic_50,
        R.drawable.ic_51,
        R.drawable.ic_52,
        R.drawable.ic_53,
        R.drawable.ic_54,
        R.drawable.ic_55,
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
        if(!WallPaperUtils.getComplex2(listOf("22", "33"), 23)){
            return ""
        }
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            "Version information not available"
        }
    }

    private fun getBrand(context: Context): String {
        if(!WallPaperUtils.getComplex2(listOf("22", "33"), 23)){
            return ""
        }
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.networkOperator
    }





    fun getCloudNetWithOkHttp(url: String, map: Map<String, Any>, onSuccess: (response: String) -> Unit, onError: (error: String) -> Unit) {
        if(!WallPaperUtils.getComplex2(listOf("asdasd", "xczc"), 665)){
            return
        }
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