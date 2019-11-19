package com.test.testsream.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.test.testsream.R
import com.test.testsream.model.NewsResult


class NewsAdapter(val newsList: List<NewsResult>?) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun getItemCount()=newsList!!.size

    private var mContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        this.mContext=parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
/*
        val mNews = newsList!!.get(position)

        if (mNews.thumbnail != null) {
            Glide.with(mContext!!)
                .load(mNews.thumbnail)
                .into(holder.ivThumbnail)
        }
        if (mNews.title != null) {
            holder.tvTitle.setText(mNews.title)
        }

        if (mNews.description != null) {
            holder.tvDescription.setText(mNews.description)
        }

        if (mNews.link != null) {
            holder.tvLink.setText(mNews.link)
        }

        holder.tvLink.setOnClickListener{
            if (mNews.link != null) {
                try {
                    val intent = Intent()
                    intent.setAction(Intent.ACTION_VIEW)
                    intent.addCategory(Intent.CATEGORY_BROWSABLE)
                    intent.setData(Uri.parse(mNews.link))
                    mContext!!.startActivity(intent)
                } catch (e:Exception ) {

                }
            }
        }*/
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val ivThumbnail:ImageView = itemView.findViewById(R.id.ivThumbnail)
        val tvTitle:TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription:TextView = itemView.findViewById(R.id.tvDescription)
        val tvLink:TextView = itemView.findViewById(R.id.tvLink)
    }
}