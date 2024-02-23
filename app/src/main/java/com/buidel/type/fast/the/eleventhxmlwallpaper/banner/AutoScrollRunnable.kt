package com.buidel.type.fast.the.eleventhxmlwallpaper.banner

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AutoScrollRunnable (private val recyclerView: RecyclerView) : Runnable {
    override fun run() {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.smoothScrollToPosition((layoutManager.findFirstVisibleItemPosition() + 1) % recyclerView.adapter!!.itemCount)

        recyclerView.postDelayed(this, 3000)
    }
}