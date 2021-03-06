package kr.co.saramin.fastandroidstudy.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RetroApi {
    companion object {
        val baseUrl = "http://evey.kro.kr"
        fun create(): Api {
            val okHttp = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttp)
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}