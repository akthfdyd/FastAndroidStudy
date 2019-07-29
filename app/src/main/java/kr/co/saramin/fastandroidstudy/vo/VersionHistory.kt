package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VersionHistory {

    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("href")
    @Expose
    var href: String? = null

}
