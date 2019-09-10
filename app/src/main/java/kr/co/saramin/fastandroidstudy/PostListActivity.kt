package kr.co.saramin.fastandroidstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_post_list.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kr.co.saramin.fastandroidstudy.adapter.PostListAdapter
import kr.co.saramin.fastandroidstudy.data.Preferences
import kr.co.saramin.fastandroidstudy.network.RetroApi
import kr.co.saramin.fastandroidstudy.vo.BlogPostResponseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

//        val preload = Preferences.getInstance(this).saveDataString
//        if (preload != "") {
//            val postArrayPreload =
//                Gson().fromJson(preload, Array<BlogPostResponseModel>::class.java)
//            onSuccessGetPostList(postArrayPreload)
//        }

//        getPostList()

        getPostListOnCoroutineScope()
    }

    private fun getPostList() {

        // new client way
//        val okHttp = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor()).build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://projectevey.000webhostapp.com")
//            .client(okHttp)
//            .build()
//
//        val service = retrofit.create(Api::class.java)
//        val blogPost = service.getPostListData()

        // creator wrapping way
        val blogPost = RetroApi.create().getPostListData()

        blogPost.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                try {
                    val result = response.body()?.string()
                    Log.v("PostListActivity", "urlConnection() onResponse >> $result")
                    if (result != null) {
                        Preferences.getInstance(this@PostListActivity).saveDataString = result
                    }
                    val blogPostResponseArray =
                        Gson().fromJson(result, Array<BlogPostResponseModel>::class.java)
                    onSuccessGetPostList(blogPostResponseArray)
                } catch (e: Exception) {
                    Log.v("PostListActivity", "urlConnection() exception >> ${e.message}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.v("PostListActivity", "urlConnection() onFailure >> ${t.message}")
            }
        })
    }

    // coroutine way
    private fun getPostListOnCoroutineScope() {
        GlobalScope.launch {
            try {
                val response = RetroApi.create().getPostListData().execute()
                if (response.isSuccessful) {
                    val result = response.body()?.string()
                    Log.v("PostListActivity", "urlConnection() onResponse >> $result")
                    val blogPostResponseArray =
                        Gson().fromJson(result, Array<BlogPostResponseModel>::class.java)
                    runOnUiThread { onSuccessGetPostList(blogPostResponseArray) }
                } else {
                    Log.v("PostListActivity","urlConnection() exception >> ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.v("PostListActivity", "urlConnection() exception >> ${e.message}")
            }
        }
    }


    private fun onSuccessGetPostList(result: Array<BlogPostResponseModel>) {
        val listAdapter = PostListAdapter()
        listAdapter.listData = result.toList()
        postListView.adapter = listAdapter
    }


    private fun getImageList() {
        val blogPost = RetroApi.create().getPostListData()

        blogPost.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                try {
                    val result = response.body()?.string()
                    Log.v("PostListActivity", "urlConnection() onResponse >> $result")
                    if (result != null) {
                        Preferences.getInstance(this@PostListActivity).saveDataString = result
                    }
                    val blogPostResponseArray =
                        Gson().fromJson(result, Array<BlogPostResponseModel>::class.java)
                    onSuccessGetImageList(blogPostResponseArray)
                } catch (e: Exception) {
                    Log.v("PostListActivity", "urlConnection() exception >> ${e.message}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.v("SecondActivity", "urlConnection() onFailure >> ${t.message}")
            }
        })
    }


    private fun onSuccessGetImageList(result: Array<BlogPostResponseModel>) {
        val listAdapter = PostListAdapter()
        listAdapter.listData = result.toList()
        postListView.adapter = listAdapter
    }


}
