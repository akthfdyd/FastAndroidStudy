package kr.co.saramin.fastandroidstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_second.*
import kr.co.saramin.fastandroidstudy.network.Api
import kr.co.saramin.fastandroidstudy.vo.BlogPostResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Int? <- Nullable type. it can be null, so you need 'null check' for use
        // ?. <- safe call, when object is not null
        // ?.let <- run block with 'it' if it is not null
        val backgroundColor: Int? = intent?.extras?.getInt("backgroundColor")
        backgroundColor?.let { layoutContainer.setBackgroundColor(it) }

        titleText.text = intent?.extras?.getString("title")
        urlConnection()
    }

    // Chapter #6. Intent, Transition
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.nothing, R.anim.fade_out)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.fade_out)
    }


    // Chapter #7. Retrofit, Gson
    fun urlConnection() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://projectevey.000webhostapp.com")
                .build()

        val service = retrofit.create(Api::class.java)

        val blogPost = service.getPostData()
        blogPost.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                try {
                    val result = response.body()?.string()
                    Log.v("SecondActivity", "urlConnection() onResponse >> " + result)
                    val blogPostResponse = Gson().fromJson(result, BlogPostResponse::class.java)
                    showResponseData(blogPostResponse)
                } catch (e: Exception) {
                    Log.v("SecondActivity", "urlConnection() exception >> " + e.message)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.v("SecondActivity", "urlConnection() onFailure >> " + t.message)
            }
        })
    }

    private fun showResponseData(blogPostResponse: BlogPostResponse?) {
        titleText.text = blogPostResponse?.title?.rendered
        contentText.loadData(blogPostResponse?.content?.rendered, "text/html", "UTF-8")
    }
}
