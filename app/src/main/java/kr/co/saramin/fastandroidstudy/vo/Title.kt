package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Title {

    @SerializedName("rendered")
    @Expose
    var rendered: String? = null

}