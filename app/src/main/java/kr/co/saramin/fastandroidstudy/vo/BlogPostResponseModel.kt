package kr.co.saramin.fastandroidstudy.vo


import com.google.gson.annotations.SerializedName

data class BlogPostResponseModel(
    @SerializedName("author")
    var author: Int? = null,

    @SerializedName("categories")
    var categories: List<Int?>? = null,

    @SerializedName("comment_status")
    var commentStatus: String? = null,

    @SerializedName("content")
    var content: Content? = null,

    @SerializedName("date")
    var date: String? = null,
    @SerializedName("date_gmt")
    var dateGmt: String? = null,
    @SerializedName("excerpt")
    var excerpt: Excerpt? = null,
    @SerializedName("featured_media")
    var featuredMedia: Int? = null,
    @SerializedName("format")
    var format: String? = null,
    @SerializedName("guid")
    var guid: Guid? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("link")
    var link: String? = null,
    @SerializedName("_links")
    var links: Links? = null,
    @SerializedName("meta")
    var meta: List<Any?>? = null,
    @SerializedName("modified")
    var modified: String? = null,
    @SerializedName("modified_gmt")
    var modifiedGmt: String? = null,
    @SerializedName("ping_status")
    var pingStatus: String? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("sticky")
    var sticky: Boolean? = null,
    @SerializedName("tags")
    var tags: List<Any?>? = null,
    @SerializedName("template")
    var template: String? = null,
    @SerializedName("title")
    var title: Title? = null,
    @SerializedName("type")
    var type: String? = null
) {
    data class Content(
        @SerializedName("protected")
        var `protected`: Boolean? = null,
        @SerializedName("rendered")
        var rendered: String? = null
    )

    data class Excerpt(
        @SerializedName("protected")
        var `protected`: Boolean? = null,
        @SerializedName("rendered")
        var rendered: String? = null
    )

    data class Guid(
        @SerializedName("rendered")
        var rendered: String? = null
    )

    data class Links(
        @SerializedName("about")
        var about: List<About?>? = null,
        @SerializedName("author")
        var author: List<Author?>? = null,
        @SerializedName("collection")
        var collection: List<Collection?>? = null,
        @SerializedName("curies")
        var curies: List<Cury?>? = null,
        @SerializedName("predecessor-version")
        var predecessorVersion: List<PredecessorVersion?>? = null,
        @SerializedName("replies")
        var replies: List<Reply?>? = null,
        @SerializedName("self")
        var self: List<Self?>? = null,
        @SerializedName("version-history")
        var versionHistory: List<VersionHistory?>? = null,
        @SerializedName("wp:attachment")
        var wpAttachment: List<WpAttachment?>? = null,
        @SerializedName("wp:featuredmedia")
        var wpFeaturedmedia: List<WpFeaturedmedia?>? = null,
        @SerializedName("wp:term")
        var wpTerm: List<WpTerm?>? = null
    ) {
        data class About(
            @SerializedName("href")
            var href: String? = null
        )

        data class VersionHistory(
            @SerializedName("count")
            var count: Int? = null,
            @SerializedName("href")
            var href: String? = null
        )

        data class Author(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null
        )

        data class Self(
            @SerializedName("href")
            var href: String? = null
        )

        data class Cury(
            @SerializedName("href")
            var href: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("templated")
            var templated: Boolean? = null
        )

        data class WpTerm(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null,
            @SerializedName("taxonomy")
            var taxonomy: String? = null
        )

        data class PredecessorVersion(
            @SerializedName("href")
            var href: String? = null,
            @SerializedName("id")
            var id: Int? = null
        )

        data class Collection(
            @SerializedName("href")
            var href: String? = null
        )

        data class WpAttachment(
            @SerializedName("href")
            var href: String? = null
        )

        data class Reply(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null
        )

        data class WpFeaturedmedia(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null
        )
    }

    data class Title(
        @SerializedName("rendered")
        var rendered: String? = null
    )
}