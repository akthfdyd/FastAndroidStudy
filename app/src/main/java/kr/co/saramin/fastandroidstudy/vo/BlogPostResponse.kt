package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BlogPostResponse {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("date_gmt")
    @Expose
    var dateGmt: String? = null
    @SerializedName("guid")
    @Expose
    var guid: Guid? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("modified_gmt")
    @Expose
    var modifiedGmt: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("title")
    @Expose
    var title: Title? = null
    @SerializedName("content")
    @Expose
    var content: Content? = null
    @SerializedName("excerpt")
    @Expose
    var excerpt: Excerpt? = null
    @SerializedName("author")
    @Expose
    var author: Int? = null
    @SerializedName("featured_media")
    @Expose
    var featuredMedia: Int? = null
    @SerializedName("comment_status")
    @Expose
    var commentStatus: String? = null
    @SerializedName("ping_status")
    @Expose
    var pingStatus: String? = null
    @SerializedName("sticky")
    @Expose
    var sticky: Boolean? = null
    @SerializedName("template")
    @Expose
    var template: String? = null
    @SerializedName("format")
    @Expose
    var format: String? = null
    @SerializedName("meta")
    @Expose
    var meta: List<Any>? = null
    @SerializedName("categories")
    @Expose
    var categories: List<Int>? = null
    @SerializedName("tags")
    @Expose
    var tags: List<Any>? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}
