package kr.co.saramin.fastandroidstudy

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.Pair
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.saramin.fastandroidstudy.network.Api
import kr.co.saramin.fastandroidstudy.network.RetroApi
import kr.co.saramin.fastandroidstudy.vo.BlogPostResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    val MSG_LOG_HELLWORLD = 1000
    val MSG_ACTIVITY_FINISH = 1001
    val MSG_REPEAT_EVERY_5_SEC = 1002

    val REQUEST_SECOND_ACTIVITY = 2000
    val REQUEST_THIRD_ACTIVITY = 2001

    // Chapter #2. Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)

        initListener()
//        handlerTests()
    }

    override fun onStart() {
        Log.v("MainActivity", "onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.v("MainActivity", "onStop")
        super.onStop()
    }

    override fun onPause() {
        Log.v("MainActivity", "onPause")
        super.onPause()
    }

    override fun onResume() {
        Log.v("MainActivity", "onResume")
        super.onResume()
    }

    override fun onRestart() {
        Log.v("MainActivity", "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.v("MainActivity", "onDestroy")
        super.onDestroy()
    }


    // Chapter #4. Listener
    fun initListener() {
        backButton.setOnClickListener { onBackPressed() }
        centerText.setOnClickListener {
            centerText.text = "Hell World"
            urlConnection()
        }
        nextButton.setOnClickListener { startSecondActivity() }

        backgroundSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                layoutContainer.setBackgroundColor(Color.parseColor("#444444"))
            } else {
                layoutContainer.setBackgroundColor(Color.parseColor("#999999"))
            }
        }

        profileImage.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    centerText.text = "Don't touch my face"
                }
                MotionEvent.ACTION_MOVE -> {
                    centerText.text = "No, no.. do not rub"
                }
                MotionEvent.ACTION_UP -> {
                    centerText.text = "OK, don't bother me again"
                }
            }
            true
        }
    }


    // Chapter #5. Handler
    @SuppressLint("HandlerLeak")
    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_LOG_HELLWORLD -> Log.v("MainActivity", "hell world")
                MSG_ACTIVITY_FINISH -> onBackPressed()
                MSG_REPEAT_EVERY_5_SEC -> toastMessage()
            }
        }
    }

    fun toastMessage() {
        Toast.makeText(this, "Developers try exit the Hell", Toast.LENGTH_SHORT).show()
        handler.sendEmptyMessageDelayed(MSG_REPEAT_EVERY_5_SEC, 5000)
    }

//    fun handlerTests() {
//        // Handler 1
//        Handler().postDelayed({
//            Log.v("MainActivity", "Log after 2 second")
//        }, 2000)
//        handler.sendEmptyMessage(MSG_LOG_HELLWORLD)
//        handler.sendEmptyMessageDelayed(MSG_ACTIVITY_FINISH, 10000)
//        handler.sendEmptyMessage(MSG_REPEAT_EVERY_5_SEC)
//    }


    // Chapter #6. Intent, Transition
    fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        if (backgroundSwitch.isChecked) {
            intent.putExtra("backgroundColor", Color.parseColor("#444444"))
        } else {
            intent.putExtra("backgroundColor", Color.parseColor("#999999"))
        }
        intent.putExtra("title", centerText.text.toString())

        // 1 Anim XML transition
//        startActivityForResult(intent, REQUEST_SECOND_ACTIVITY)
//        overridePendingTransition(R.anim.fade_in, R.anim.nothing)

        // 2 Styles XML transition
//        val options = ActivityOptions.makeSceneTransitionAnimation(this)
//        startActivityForResult(intent, REQUEST_SECOND_ACTIVITY, options.toBundle())

        // 3 Hero animation
        val pair0 = Pair<View, String>(profileImage, "profileImage")
        val pair1 = Pair<View, String>(centerText, "titleText")
        val options = ActivityOptions.makeSceneTransitionAnimation(this, pair0, pair1)
        startActivityForResult(intent, REQUEST_SECOND_ACTIVITY, options.toBundle())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_SECOND_ACTIVITY -> centerText.text = "Came from SecondActivity"
            REQUEST_THIRD_ACTIVITY -> centerText.text = "Came from ThirdActivity"
        }
    }


    // Chapter #7. Retrofit, Gson
    fun urlConnection() {
        val retrofit = Retrofit.Builder()
            .baseUrl(RetroApi.baseUrl)
            .build()

        val service = retrofit.create(Api::class.java)

        val blogPost = service.getPostData()
        blogPost.enqueue(object : Callback<okhttp3.ResponseBody> {
            override fun onResponse(call: Call<okhttp3.ResponseBody>, response: Response<okhttp3.ResponseBody>) {
                try {
                    val result = response.body()?.string()
                    Log.v("MainActivity", "urlConnection() onResponse >> " + result)

                    // traditional way
//                    val jsonObject = JSONObject(result)
//                    val title = jsonObject.getJSONObject("title").get("rendered")
//                    Log.v("MainActivity", "urlConnection() onResponse JSONObject >> " + title)
//                    showResponseData(title.toString())
//
                    // use GSON
                    val blogPostResponse = Gson().fromJson(result, BlogPostResponseModel::class.java)
                    Log.v("MainActivity", "urlConnection() onResponse GSON >> " + blogPostResponse?.title?.rendered)
                    showResponseData(blogPostResponse?.title?.rendered.toString())
                } catch (e: Exception) {
                    Log.v("MainActivity", "urlConnection() exception >> " + e.message)
                }
            }

            override fun onFailure(call: Call<okhttp3.ResponseBody>, t: Throwable) {
                Log.v("MainActivity", "urlConnection() onFailure >> " + t.message)
            }
        })
    }

    private fun showResponseData(str: String) {
        centerText.text = str
    }


}
