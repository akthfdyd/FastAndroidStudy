package kr.co.saramin.fastandroidstudy.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WpTerm {

    @SerializedName("taxonomy")
    @Expose
    var taxonomy: String? = null
    @SerializedName("embeddable")
    @Expose
    var embeddable: Boolean? = null
    @SerializedName("href")
    @Expose
    var href: String? = null

}
