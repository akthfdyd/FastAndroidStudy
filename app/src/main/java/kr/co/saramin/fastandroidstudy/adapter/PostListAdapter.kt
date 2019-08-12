package kr.co.saramin.fastandroidstudy.adapter

import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kr.co.saramin.fastandroidstudy.R
import kr.co.saramin.fastandroidstudy.SecondActivity
import kr.co.saramin.fastandroidstudy.WebViewActivity
import kr.co.saramin.fastandroidstudy.vo.BlogPostResponseModel

// #8. RecyclerView
class PostListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var listData: List<BlogPostResponseModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.onBind(listData[position])
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(data: BlogPostResponseModel) {
            val container = itemView.findViewById<ConstraintLayout>(R.id.itemContainer)
            val title = itemView.findViewById<TextView>(R.id.postTitle)

            title.text = data.title?.rendered

            container.setOnClickListener {
                val intent = Intent(itemView.context, WebViewActivity::class.java)
                intent.putExtra("title", data.title?.rendered)
                intent.putExtra("content", data.content?.rendered)
                intent.putExtra("link", data.link)
                itemView.context.startActivity(intent)
            }
        }
    }
}