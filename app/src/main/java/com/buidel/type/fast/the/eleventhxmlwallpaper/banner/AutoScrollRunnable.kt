package com.buidel.type.fast.the.eleventhxmlwallpaper.banner

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils.getComplex2
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils.getComplexFalse

class AutoScrollRunnable (private val recyclerView: RecyclerView) : Runnable {
    override fun run() {
        if(getComplexFalse("sd", listOf(67, 89, 90))) {
           return
        }
        if(getComplex2(listOf("22", "33"), 23)) {
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            recyclerView.smoothScrollToPosition((layoutManager.findFirstVisibleItemPosition() + 1) % recyclerView.adapter!!.itemCount)
            recyclerView.postDelayed(this, 3000)
        }
    }
}