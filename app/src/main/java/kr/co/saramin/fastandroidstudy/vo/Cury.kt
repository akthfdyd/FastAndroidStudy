package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cury {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("href")
    @Expose
    var href: String? = null
    @SerializedName("templated")
    @Expose
    var templated: Boolean? = null

}
