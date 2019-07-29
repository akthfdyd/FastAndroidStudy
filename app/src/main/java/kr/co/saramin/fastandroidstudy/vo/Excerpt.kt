package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Excerpt {

    @SerializedName("rendered")
    @Expose
    var rendered: String? = null
    @SerializedName("protected")
    @Expose
    var protected: Boolean? = null

}
