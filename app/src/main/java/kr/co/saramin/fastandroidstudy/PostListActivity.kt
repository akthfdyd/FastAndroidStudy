package kr.co.saramin.fastandroidstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_post_list.*
import kr.co.saramin.fastandroidstudy.adapter.PostListAdapter
import kr.co.saramin.fastandroidstudy.network.Api
import kr.co.saramin.fastandroidstudy.vo.BlogPostResponseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class PostListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        getPostList()
    }

    private fun getPostList() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://projectevey.000webhostapp.com")
                .build()

        val service = retrofit.create(Api::class.java)

        val blogPost = service.getPostListData()
        blogPost.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                try {
                    val result = response.body()?.string()
                    Log.v("PostListActivity", "urlConnection() onResponse >> $result")
                    val blogPostResponseArray = Gson().fromJson(result, Array<BlogPostResponseModel>::class.java)
                    onSuccessGetPostList(blogPostResponseArray)
                } catch (e: Exception) {
                    Log.v("PostListActivity", "urlConnection() exception >> ${e.message}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.v("SecondActivity", "urlConnection() onFailure >> ${t.message}")
            }
        })
    }


    private fun onSuccessGetPostList(result: Array<BlogPostResponseModel>) {
        val listAdapter = PostListAdapter()
        listAdapter.listData = result.toList()
        postListView.adapter = listAdapter
    }

    private fun onErrorGetSelQuestionSet(error: Throwable?) {

    }

}
