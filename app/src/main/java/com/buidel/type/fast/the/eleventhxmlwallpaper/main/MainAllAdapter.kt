package com.buidel.type.fast.the.eleventhxmlwallpaper.main
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.buidel.type.fast.the.eleventhxmlwallpaper.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainAllAdapter (private var dataList: List<Int>,context: Context) :
    RecyclerView.Adapter<MainAllAdapter.ViewHolder>() {
        private val context = context
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItem: ImageView = itemView.findViewById(R.id.all_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_all, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        loadImage(context, position, holder.imgItem)
            .subscribeOn(Schedulers.io()) // 在IO线程上执行图片加载
            .observeOn(AndroidSchedulers.mainThread()) // 在主线程上处理加载完成
            .subscribe(
                {
                    // 图片加载成功，这里不需要额外操作，因为图片设置已在onResourceReady中完成
                },
                { error ->
                    // 处理图片加载失败的情况
                    Log.e("ImageLoad", "Error loading image", error)
                }
            )

        holder.itemView.setOnClickListener {
            listener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun loadImage(context: Context, position: Int, imageView: ImageView): Completable {
        return Completable.create { emitter ->
            Glide.with(context)
                .load(dataList[position])
                .thumbnail(0.12f)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        imageView.setImageDrawable(resource)
                        emitter.onComplete()
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                        // 可以在这里处理资源清理
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        super.onLoadFailed(errorDrawable)
                        imageView.setImageDrawable(errorDrawable)
                        emitter.onError(Throwable("Image load failed"))
                    }
                })

            // 当Completable被取消订阅时，取消Glide的加载请求
            emitter.setCancellable {
                Glide.with(context).clear(imageView)
            }
        }
    }

}