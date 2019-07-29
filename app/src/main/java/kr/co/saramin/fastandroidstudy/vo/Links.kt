package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("self")
    @Expose
    var self: List<Self>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection>? = null
    @SerializedName("about")
    @Expose
    var about: List<About>? = null
    @SerializedName("author")
    @Expose
    var author: List<Author>? = null
    @SerializedName("replies")
    @Expose
    var replies: List<Reply>? = null
    @SerializedName("version-history")
    @Expose
    var versionHistory: List<VersionHistory>? = null
    @SerializedName("predecessor-version")
    @Expose
    var predecessorVersion: List<PredecessorVersion>? = null
    @SerializedName("wp:attachment")
    @Expose
    var wpAttachment: List<WpAttachment>? = null
    @SerializedName("wp:term")
    @Expose
    var wpTerm: List<WpTerm>? = null
    @SerializedName("curies")
    @Expose
    var curies: List<Cury>? = null

}
