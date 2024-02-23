package com.buidel.type.fast.the.eleventhxmlwallpaper.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.buidel.type.fast.the.eleventhxmlwallpaper.DataWallPaper
import com.buidel.type.fast.the.eleventhxmlwallpaper.R
import com.buidel.type.fast.the.eleventhxmlwallpaper.banner.AutoScrollRunnable
import com.buidel.type.fast.the.eleventhxmlwallpaper.banner.CircleIndicator
import com.buidel.type.fast.the.eleventhxmlwallpaper.end.EndActivity
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewAll: RecyclerView
    private lateinit var recyclerViewBanner: RecyclerView
    private lateinit var indicator: CircleIndicator
    private lateinit var ill: LinearLayout
    private lateinit var llNa: LinearLayout
    private lateinit var ppText: TextView
    private lateinit var clMain: ConstraintLayout
    private lateinit var imageView2: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewAll = findViewById(R.id.recyclerView)
        recyclerViewBanner = findViewById(R.id.rv_banner)
        ill = findViewById(R.id.ilLinearLayout)
        ppText = findViewById(R.id.tv_pp)
        llNa = findViewById(R.id.llNa)
        clMain = findViewById(R.id.cl_main)
        imageView2 = findViewById(R.id.imageView2)
        initAll()
        initBanner()
        cli()
    }

    private fun initAll() {
        val allAdapter = MainAllAdapter(DataWallPaper.localImageData,this)
        recyclerViewAll.adapter = allAdapter
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerViewAll.layoutManager = gridLayoutManager
        allAdapter.setOnItemClickListener(object : MainAllAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                DataWallPaper.imgType = true
                jumpToDetail(position)
            }
        })
    }

    private fun initBanner() {
        val bannerAdapter = MainBannerAdapter(DataWallPaper.localBannerImageData)
        recyclerViewBanner.adapter = bannerAdapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewBanner.layoutManager = layoutManager
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(recyclerViewBanner)
        indicator = CircleIndicator(this, ill, recyclerViewBanner)
        indicator.createDotPanel(DataWallPaper.localBannerImageData.size)
        recyclerViewBanner.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val position = layoutManager.findFirstCompletelyVisibleItemPosition()
                indicator.updateIndicator(position % DataWallPaper.localBannerImageData.size)
            }
        })
        bannerAdapter.setOnItemClickListener(object : MainBannerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                DataWallPaper.imgType = false
                jumpToDetail(position)
            }
        })

        val autoScrollRunnable = AutoScrollRunnable(recyclerViewBanner)
        recyclerViewBanner.postDelayed(autoScrollRunnable, 3000)
    }

    fun jumpToDetail(position: Int) {
        if(WallPaperUtils.getComplex1("sd", 67) && llNa.isVisible){
            llNa.visibility = View.GONE
            return
        }
        DataWallPaper.posInt = position
        Intent(this, EndActivity::class.java).apply {}.also {
            startActivity(it)
        }
    }

    private fun cli() {
        imageView2.setOnClickListener {
            llNa.visibility = View.VISIBLE
        }
        clMain.setOnClickListener {
            llNa.visibility =View.GONE
        }
        llNa.setOnClickListener {  }
        ppText.setOnClickListener {
            //跳转浏览器
            val intent = Intent()
            intent.action = "android.intent.action.VIEW"
            intent.data = android.net.Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }
    }
}