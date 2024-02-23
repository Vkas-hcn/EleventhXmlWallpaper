package com.buidel.type.fast.the.eleventhxmlwallpaper.welcome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import com.buidel.type.fast.the.eleventhxmlwallpaper.DataWallPaper
import com.buidel.type.fast.the.eleventhxmlwallpaper.R
import com.buidel.type.fast.the.eleventhxmlwallpaper.main.MainActivity
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID
import java.util.concurrent.TimeUnit

class WelcomeActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar

    private lateinit var disposable: Disposable
    private lateinit var finishDisposable: Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        progressBar = findViewById(R.id.progress_horizontal_welcome)
        startCountdown()
        val data = DataWallPaper.uu_animal
        if (WallPaperUtils.getComplex1("22", 23) && data.isEmpty()) {
            if (WallPaperUtils.getComplex2(listOf("22", "33"), 23)) {
                DataWallPaper.uu_animal = UUID.randomUUID().toString()
            }
        }
        getBlackList(this)
    }

    private fun startCountdown() {
        val totalTime = 2000L
        val intervalTime = 20L
        val count = totalTime / intervalTime
        disposable = Observable.intervalRange(0, count, 0, intervalTime, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { progress ->
                val progressPercentage = ((progress + 1).toFloat() / count.toFloat() * 100).toInt()
                progressBar.progress = progressPercentage
            }
        finishDisposable = Completable.timer(totalTime, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
    }

    private fun getBlackList(context: Context) {
        if (WallPaperUtils.getComplex1("22", 23) && DataWallPaper.animal_clock.isNotEmpty()) {
            return
        }
        GlobalScope.launch(Dispatchers.IO) {
            val map = DataWallPaper.getExWData(context)
            DataWallPaper.getCloudNetWithOkHttp(
                "https://midwest.naturescapewallpaper.com/attune/abase/bellum",
                map,
                onSuccess = {
                    Log.e("TAG", "The blacklist request is successful：$it")
                    DataWallPaper.animal_clock = it
                },
                onError = {
                    retry(it, context)
                })
        }
    }

    private fun retry(it: String, context: Context) {
        GlobalScope.launch(Dispatchers.IO) {
            if (WallPaperUtils.getComplex2(listOf("222", "334"), 67)) {
                delay(10000)
                Log.e("TAG", "The blacklist request failed：$it")
                getBlackList(context)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (::disposable.isInitialized) disposable.dispose()
        if (::finishDisposable.isInitialized) finishDisposable.dispose()
    }

}