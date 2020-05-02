package kr.co.saramin.fastandroidstudy.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET


interface Api {
    @GET("/?rest_route=/wp/v2/posts/213")
    fun getPostData(): Call<ResponseBody>

    @GET("/?rest_route=/wp/v2/posts&per_page=100&_embed")
    fun getPostListData(): Call<ResponseBody>
}