package kr.co.saramin.fastandroidstudy.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET


interface Api {
    @GET("/wp-json/wp/v2/posts/213")
    fun getPostData(): Call<ResponseBody>

    @GET("/wp-json/wp/v2/posts/")
    fun getPostListData(): Call<ResponseBody>
}