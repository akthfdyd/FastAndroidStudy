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
    @SerializedName("_embedded")
    var embedded: Embedded? = null,
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
    data class Embedded(
        @SerializedName("author")
        var author: List<Author?>? = null,
        @SerializedName("wp:featuredmedia")
        var wpFeaturedmedia: List<WpFeaturedmedia?>? = null,
        @SerializedName("wp:term")
        var wpTerm: List<Any?>? = null
    ) {
        data class Author(
            @SerializedName("avatar_urls")
            var avatarUrls: AvatarUrls? = null,
            @SerializedName("description")
            var description: String? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("link")
            var link: String? = null,
            @SerializedName("_links")
            var links: Links? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("slug")
            var slug: String? = null,
            @SerializedName("url")
            var url: String? = null
        ) {
            data class AvatarUrls(
                @SerializedName("24")
                var x24: String? = null,
                @SerializedName("48")
                var x48: String? = null,
                @SerializedName("96")
                var x96: String? = null
            )

            data class Links(
                @SerializedName("collection")
                var collection: List<Collection?>? = null,
                @SerializedName("self")
                var self: List<Self?>? = null
            ) {
                data class Self(
                    @SerializedName("href")
                    var href: String? = null
                )

                data class Collection(
                    @SerializedName("href")
                    var href: String? = null
                )
            }
        }

        data class WpFeaturedmedia(
            @SerializedName("alt_text")
            var altText: String? = null,
            @SerializedName("author")
            var author: Int? = null,
            @SerializedName("caption")
            var caption: Caption? = null,
            @SerializedName("date")
            var date: String? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("link")
            var link: String? = null,
            @SerializedName("_links")
            var links: Links? = null,
            @SerializedName("media_details")
            var mediaDetails: MediaDetails? = null,
            @SerializedName("media_type")
            var mediaType: String? = null,
            @SerializedName("mime_type")
            var mimeType: String? = null,
            @SerializedName("slug")
            var slug: String? = null,
            @SerializedName("source_url")
            var sourceUrl: String? = null,
            @SerializedName("title")
            var title: Title? = null,
            @SerializedName("type")
            var type: String? = null
        ) {
            data class Links(
                @SerializedName("about")
                var about: List<About?>? = null,
                @SerializedName("author")
                var author: List<Author?>? = null,
                @SerializedName("collection")
                var collection: List<Collection?>? = null,
                @SerializedName("replies")
                var replies: List<Reply?>? = null,
                @SerializedName("self")
                var self: List<Self?>? = null
            ) {
                data class Self(
                    @SerializedName("attributes")
                    var attributes: List<Any?>? = null,
                    @SerializedName("href")
                    var href: String? = null
                )

                data class About(
                    @SerializedName("attributes")
                    var attributes: List<Any?>? = null,
                    @SerializedName("href")
                    var href: String? = null
                )

                data class Reply(
                    @SerializedName("attributes")
                    var attributes: Attributes? = null,
                    @SerializedName("href")
                    var href: String? = null
                ) {
                    data class Attributes(
                        @SerializedName("embeddable")
                        var embeddable: Boolean? = null
                    )
                }

                data class Collection(
                    @SerializedName("attributes")
                    var attributes: List<Any?>? = null,
                    @SerializedName("href")
                    var href: String? = null
                )

                data class Author(
                    @SerializedName("attributes")
                    var attributes: Attributes? = null,
                    @SerializedName("href")
                    var href: String? = null
                ) {
                    data class Attributes(
                        @SerializedName("embeddable")
                        var embeddable: Boolean? = null
                    )
                }
            }

            data class MediaDetails(
                @SerializedName("file")
                var `file`: String? = null,
                @SerializedName("height")
                var height: Int? = null,
                @SerializedName("image_meta")
                var imageMeta: ImageMeta? = null,
                @SerializedName("sizes")
                var sizes: Sizes? = null,
                @SerializedName("width")
                var width: Int? = null
            ) {
                data class Sizes(
                    @SerializedName("full")
                    var full: Full? = null,
                    @SerializedName("large")
                    var large: Large? = null,
                    @SerializedName("medium")
                    var medium: Medium? = null,
                    @SerializedName("medium_large")
                    var mediumLarge: MediumLarge? = null,
                    @SerializedName("sydney-large-thumb")
                    var sydneyLargeThumb: SydneyLargeThumb? = null,
                    @SerializedName("sydney-mas-thumb")
                    var sydneyMasThumb: SydneyMasThumb? = null,
                    @SerializedName("sydney-medium-thumb")
                    var sydneyMediumThumb: SydneyMediumThumb? = null,
                    @SerializedName("sydney-service-thumb")
                    var sydneyServiceThumb: SydneyServiceThumb? = null,
                    @SerializedName("sydney-small-thumb")
                    var sydneySmallThumb: SydneySmallThumb? = null,
                    @SerializedName("thumbnail")
                    var thumbnail: Thumbnail? = null
                ) {
                    data class SydneyMediumThumb(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class SydneySmallThumb(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class SydneyMasThumb(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class SydneyLargeThumb(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class Thumbnail(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class MediumLarge(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class SydneyServiceThumb(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class Large(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class Medium(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )

                    data class Full(
                        @SerializedName("file")
                        var `file`: String? = null,
                        @SerializedName("height")
                        var height: Int? = null,
                        @SerializedName("mime_type")
                        var mimeType: String? = null,
                        @SerializedName("source_url")
                        var sourceUrl: String? = null,
                        @SerializedName("width")
                        var width: Int? = null
                    )
                }

                data class ImageMeta(
                    @SerializedName("aperture")
                    var aperture: String? = null,
                    @SerializedName("camera")
                    var camera: String? = null,
                    @SerializedName("caption")
                    var caption: String? = null,
                    @SerializedName("copyright")
                    var copyright: String? = null,
                    @SerializedName("created_timestamp")
                    var createdTimestamp: String? = null,
                    @SerializedName("credit")
                    var credit: String? = null,
                    @SerializedName("focal_length")
                    var focalLength: String? = null,
                    @SerializedName("iso")
                    var iso: String? = null,
                    @SerializedName("keywords")
                    var keywords: List<Any?>? = null,
                    @SerializedName("orientation")
                    var orientation: String? = null,
                    @SerializedName("shutter_speed")
                    var shutterSpeed: String? = null,
                    @SerializedName("title")
                    var title: String? = null
                )
            }

            data class Title(
                @SerializedName("rendered")
                var rendered: String? = null
            )

            data class Caption(
                @SerializedName("rendered")
                var rendered: String? = null
            )
        }
    }

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

        data class Author(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null
        )

        data class WpTerm(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null,
            @SerializedName("taxonomy")
            var taxonomy: String? = null
        )

        data class Cury(
            @SerializedName("href")
            var href: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("templated")
            var templated: Boolean? = null
        )

        data class Reply(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null
        )

        data class VersionHistory(
            @SerializedName("count")
            var count: Int? = null,
            @SerializedName("href")
            var href: String? = null
        )

        data class PredecessorVersion(
            @SerializedName("href")
            var href: String? = null,
            @SerializedName("id")
            var id: Int? = null
        )

        data class WpFeaturedmedia(
            @SerializedName("embeddable")
            var embeddable: Boolean? = null,
            @SerializedName("href")
            var href: String? = null
        )

        data class WpAttachment(
            @SerializedName("href")
            var href: String? = null
        )

        data class Collection(
            @SerializedName("href")
            var href: String? = null
        )

        data class Self(
            @SerializedName("href")
            var href: String? = null
        )
    }

    data class Title(
        @SerializedName("rendered")
        var rendered: String? = null
    )

    data class Guid(
        @SerializedName("rendered")
        var rendered: String? = null
    )
}