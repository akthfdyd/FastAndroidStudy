package kr.co.saramin.fastandroidstudy.adapter

import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.co.saramin.fastandroidstudy.R
import kr.co.saramin.fastandroidstudy.WebViewActivity
import kr.co.saramin.fastandroidstudy.vo.BlogPostResponseModel

// #8. RecyclerView
class PostListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var listData: List<BlogPostResponseModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
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
            val userName = itemView.findViewById<TextView>(R.id.userName)
            val featuredImage = itemView.findViewById<AppCompatImageView>(R.id.featuredImage)
            val profileImage = itemView.findViewById<AppCompatImageView>(R.id.profileImage)

            title.text = data.title?.rendered
            userName.text = data.embedded?.author?.first()?.name

            val featuredImageUrl =
                data.embedded?.wpFeaturedmedia?.first()?.mediaDetails?.sizes?.large?.sourceUrl ?: ""
            val profileImageUrl = data.embedded?.author?.first()?.avatarUrls?.x96 ?: ""

            if (featuredImageUrl.isNotEmpty()) {
                featuredImage.visibility = View.VISIBLE
                Glide.with(itemView)
                    .load(featuredImageUrl)
                    .centerCrop()
                    .into(featuredImage)
            } else {
                featuredImage.visibility = View.GONE
            }

            profileImage.visibility = View.VISIBLE
            Glide.with(itemView)
                .load(profileImageUrl)
                .centerCrop()
                .into(profileImage)

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