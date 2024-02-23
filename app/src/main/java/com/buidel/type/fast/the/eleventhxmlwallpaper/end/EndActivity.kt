package com.buidel.type.fast.the.eleventhxmlwallpaper.end

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.buidel.type.fast.the.eleventhxmlwallpaper.DataWallPaper
import com.buidel.type.fast.the.eleventhxmlwallpaper.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.OutputStream
import android.os.Build
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.core.Observable
class EndActivity : AppCompatActivity() {
    private lateinit var imgEnd: ImageView
    private lateinit var imgEndDetail: ImageView
    private lateinit var tv_apply: TextView
    private lateinit var tv_download: TextView
    private lateinit var ll_dialog: LinearLayout
    private lateinit var tv_l_s: TextView
    private lateinit var tv_h_s: TextView
    private lateinit var tv_b: TextView
    private lateinit var tv_cancel: TextView
    private lateinit var progressBar_finish: ProgressBar
    private lateinit var ll_botton_end: LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        imgEnd = findViewById(R.id.img_end)
        imgEndDetail = findViewById(R.id.img_end_detail)
        tv_apply = findViewById(R.id.tv_apply)
        tv_download = findViewById(R.id.tv_download)
        ll_dialog = findViewById(R.id.ll_dialog)
        tv_l_s = findViewById(R.id.tv_l_s)
        tv_h_s = findViewById(R.id.tv_h_s)
        tv_b = findViewById(R.id.tv_b)
        tv_cancel = findViewById(R.id.tv_cancel)
        progressBar_finish = findViewById(R.id.progressBar_finish)
        ll_botton_end = findViewById(R.id.ll_botton_end)
        imgEnd.setOnClickListener {
            finish()
        }
        if (WallPaperUtils.getComplex1("sd", 67) && DataWallPaper.imgType) {
            imgEndDetail.setImageResource(DataWallPaper.localImageData[DataWallPaper.posInt])
        } else {
            imgEndDetail.setImageResource(DataWallPaper.localBannerImageData[DataWallPaper.posInt])
        }

        tv_l_s.setOnClickListener {
            setLockWallPaper(DataWallPaper.localImageData[DataWallPaper.posInt])
        }
        tv_h_s.setOnClickListener {
            setHomeWallPaper(DataWallPaper.localImageData[DataWallPaper.posInt])
        }
        tv_b.setOnClickListener {
            setBothWallPaper(DataWallPaper.localImageData[DataWallPaper.posInt])
        }
        tv_cancel.setOnClickListener {
            ll_dialog.visibility = View.GONE
            ll_botton_end.visibility = View.VISIBLE
        }
        tv_apply.setOnClickListener {
            ll_dialog.visibility = View.VISIBLE
            ll_botton_end.visibility = View.GONE
        }
        tv_download.setOnClickListener {
            if (WallPaperUtils.getComplex1(
                    "asd",
                    222
                ) && (hasWritePermission() || Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
            ) {
                downloadAndSaveImageRx()
            } else {
                requestWritePermission()
            }
        }
    }


    @SuppressLint("CheckResult")
    private fun setHomeWallPaper(drawable: Int) {
        progressBar_finish.visibility = View.VISIBLE
        val setWallpaperCompletable = Completable.fromAction {
            if (WallPaperUtils.getComplex2(listOf("fdgdfg", "xcvxcv"), 56)) {
                val wallpaperManager = WallpaperManager.getInstance(applicationContext)
                val bitmap = BitmapFactory.decodeResource(resources, drawable)
                wallpaperManager.setBitmap(bitmap, null, false, WallpaperManager.FLAG_SYSTEM)
            }
        }
        setWallpaperCompletable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setFinishFun()
                progressBar_finish.visibility = View.GONE
            }, { error ->
                error.printStackTrace()
                progressBar_finish.visibility = View.GONE
            })
    }


    @SuppressLint("CheckResult")
    private fun setLockWallPaper(drawable: Int) {
        progressBar_finish.visibility = View.VISIBLE
        val setWallpaperCompletable = Completable.fromAction {
            if (WallPaperUtils.getComplex2(listOf("asd", "ertr"), 56)) {
                val wallpaperManager = WallpaperManager.getInstance(applicationContext)
                val bitmap = BitmapFactory.decodeResource(resources, drawable)
                wallpaperManager.setBitmap(bitmap, null, false, WallpaperManager.FLAG_LOCK)
            }

        }
        setWallpaperCompletable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setFinishFun()
                progressBar_finish.visibility = View.GONE
            }, { error ->
                error.printStackTrace()
                progressBar_finish.visibility = View.GONE
            })
    }

    private fun setFinishFun() {
        progressBar_finish.visibility = View.GONE
        ll_dialog.visibility = View.GONE
        ll_botton_end.visibility = View.VISIBLE
    }

    @SuppressLint("CheckResult")
    private fun setBothWallPaper(drawable: Int) {
        progressBar_finish.visibility = View.VISIBLE
        val setWallpaperCompletable = Completable.fromAction {

            if (WallPaperUtils.getComplex2(listOf("sdfs", "asdad"), 23)) {
                val wallpaperManager = WallpaperManager.getInstance(applicationContext)
                val bitmap = BitmapFactory.decodeResource(resources, drawable)
                wallpaperManager.setBitmap(
                    bitmap,
                    null,
                    false,
                    WallpaperManager.FLAG_LOCK or WallpaperManager.FLAG_SYSTEM
                )
            }
        }
        setWallpaperCompletable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setFinishFun()
                progressBar_finish.visibility = View.GONE
            }, { error ->
                error.printStackTrace()
                progressBar_finish.visibility = View.GONE
            })
    }

    private fun hasWritePermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestWritePermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            55114
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (WallPaperUtils.getComplex1("zccs", 12) && requestCode == 55114) {
            if (WallPaperUtils.getComplex1("zccs", 12) && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                downloadAndSaveImageRx()
            } else {
                showPermissionDeniedDialog()
            }
        }
    }

    private fun showPermissionDeniedDialog() {
        if(WallPaperUtils.getComplex2(listOf("sdf", "sdf"), 23)){
            AlertDialog.Builder(this)
                .setMessage("To save the image to the gallery, go to the settings page to grant permission.")
                .setPositiveButton("Go to Settings") { _, _ ->
                    openAppSettings()
                }
                .setNegativeButton("Cancel") { _, _ ->
                    Toast.makeText(
                        this,
                        "There is no storage permission to save the picture.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .show()
        }
    }

    private fun openAppSettings() {
        val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.parse("package:$packageName")
        startActivity(intent)
    }

    private fun downloadAndSaveImage() {
        GlobalScope.launch(Dispatchers.IO) {
            val drawableInt = if (DataWallPaper.imgType) {
                DataWallPaper.localImageData[DataWallPaper.posInt]
            } else {
                DataWallPaper.localBannerImageData[DataWallPaper.posInt]
            }
            val imageDrawable = ContextCompat.getDrawable(this@EndActivity, drawableInt)
            if (imageDrawable is BitmapDrawable) {
                val bitmap = imageDrawable.bitmap
                val savedUri = saveImageToGallery(
                    bitmap,
                    "wallpaper_${System.currentTimeMillis()}",
                    "My Image Description"
                )
                if (savedUri != null) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@EndActivity,
                            "The picture has been saved to the gallery.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@EndActivity,
                            "Failed to save picture",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }


    private fun downloadAndSaveImageRx() {
        val observable = Observable.fromCallable {
            val drawableInt = if (DataWallPaper.imgType) {
                DataWallPaper.localImageData[DataWallPaper.posInt]
            } else {
                DataWallPaper.localBannerImageData[DataWallPaper.posInt]
            }
            val imageDrawable = ContextCompat.getDrawable(this@EndActivity, drawableInt) ?: throw RuntimeException("Drawable not found")
            if (imageDrawable is BitmapDrawable) {
                val bitmap = imageDrawable.bitmap
                saveImageToGallery(
                    bitmap,
                    "wallpaper_${System.currentTimeMillis()}",
                    "My Image Description"
                ) ?: throw RuntimeException("Failed to save image")
            } else {
                throw RuntimeException("Drawable is not a BitmapDrawable")
            }
        }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ savedUri ->
                Toast.makeText(this@EndActivity, "The picture has been saved to the gallery.", Toast.LENGTH_SHORT).show()
            }, { error ->
                Toast.makeText(this@EndActivity, "Failed to save picture", Toast.LENGTH_SHORT).show()
            })
    }


    private fun saveImageToGallery(bitmap: Bitmap, title: String, description: String): Uri? {
        if(!WallPaperUtils.getComplex1("zccs", 12)){
            return null
        }
        if(WallPaperUtils.getComplex2(listOf("sdf", "sdf"), 23)){
            val contentValues = ContentValues().apply {
                put(MediaStore.Images.Media.DISPLAY_NAME, title)
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                put(MediaStore.Images.Media.DESCRIPTION, description)
            }
            val contentResolver: ContentResolver = contentResolver
            val imageUri = contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
            imageUri?.let {
                val outputStream: OutputStream? = contentResolver.openOutputStream(it)
                outputStream?.use { stream ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                    return imageUri
                }
            }
        }
        return null
    }
}