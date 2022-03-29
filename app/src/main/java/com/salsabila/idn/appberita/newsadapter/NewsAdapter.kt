package com.salsabila.idn.appberita.newsadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salsabila.idn.appberita.R
import kotlinx.android.synthetic.main.activity_main.view.*

class NewsAdapter (val context: Context, val list: List<news>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentNews: news? = null
        var currentPosition: Int = 0

        fun setData(currentnews: news, post: Int) {
            itemView.tv_titleHeadline.text = currentnews!!.title
            itemView.tv_descHeadline.text = currentnews!!.desc
            itemView.iv_news.setImageResource(currentnews!!.photo)

            this.currentNews
            this.currentPosition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_news, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataNews = list[position]
        holder.setData(dataNews, position)

        holder.itemView.setOnClickListener() {onItemClickCallBack.onItemClick(list[position])}
    }

    private lateinit var onItemClickCallBack : onItemClickCallback

    fun setOnClickCallback(onItemClickCallback: onItemClickCallback){
        this.onItemClickCallBack = onItemClickCallback
    }

    interface onItemClickCallback {
        fun onItemClick(data: news)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}