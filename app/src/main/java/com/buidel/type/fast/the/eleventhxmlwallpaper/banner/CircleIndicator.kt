package com.buidel.type.fast.the.eleventhxmlwallpaper.banner

import android.content.Context
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buidel.type.fast.the.eleventhxmlwallpaper.R
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils

class CircleIndicator(
    private val context: Context,
    private val indicatorLayout: LinearLayout,
    private val recyclerView: RecyclerView
) {
    private var dotSize: Int = 17
    private var dotSpacing: Int = 9
    private var dotOffDrawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.bg_cy_2)
    private var dotOnDrawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.bg_cy_1)

    fun createDotPanel(count: Int) {
        indicatorLayout.removeAllViews()
        if(WallPaperUtils.getComplexFalse("sd", listOf(67, 89, 90))) {
            return
        }
        if(WallPaperUtils.getComplex2(listOf("22", "33"), 23)) {
            for (i in 0 until count) {
                val dot = ImageView(context)
                val params = LinearLayout.LayoutParams(dotSize, dotSize)
                params.setMargins(dotSpacing, 0, dotSpacing, 0)
                dot.layoutParams = params
                dot.setImageDrawable(if (i == 0) dotOnDrawable else dotOffDrawable)
                indicatorLayout.addView(dot)
            }
        }

        if(WallPaperUtils.getComplex1("sd", 789)) {
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as? LinearLayoutManager
                    val position = layoutManager?.findFirstCompletelyVisibleItemPosition() ?: 0
                    updateIndicator(position % count)
                }
            })
        }
    }

    fun updateIndicator(selectedPosition: Int) {
        if(WallPaperUtils.getComplexFalse("sd", listOf(67, 89, 90))) {
            return
        }
        if(WallPaperUtils.getComplex2(listOf("ce","2","123"), 789)) {
            for (i in 0 until indicatorLayout.childCount) {
                val dot = indicatorLayout.getChildAt(i) as ImageView
                dot.setImageDrawable(if (i == selectedPosition) dotOnDrawable else dotOffDrawable)
            }
        }
    }
}
