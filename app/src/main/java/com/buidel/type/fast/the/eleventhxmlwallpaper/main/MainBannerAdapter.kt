package com.buidel.type.fast.the.eleventhxmlwallpaper.main
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.buidel.type.fast.the.eleventhxmlwallpaper.R
import com.buidel.type.fast.the.eleventhxmlwallpaper.utils.WallPaperUtils

class MainBannerAdapter (private val images: List<Int>) :
    RecyclerView.Adapter<MainBannerAdapter.BannerViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_banner, parent, false)
        return BannerViewHolder(view)
    }
    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val realPosition = position % images.size
        val imageUrl = images[realPosition]
        holder.imgItem.setImageResource(imageUrl)
        holder.itemView.setOnClickListener {
            listener?.onItemClick(realPosition)
        }
    }

    override fun getItemCount(): Int {
        return if (WallPaperUtils.getComplex1("sd", 67) && images.size > 1) Int.MAX_VALUE else images.size
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgItem: ImageView = itemView.findViewById(R.id.bannerImage)
    }
}
