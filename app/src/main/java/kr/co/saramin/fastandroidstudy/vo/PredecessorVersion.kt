package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PredecessorVersion {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("href")
    @Expose
    var href: String? = null

}
