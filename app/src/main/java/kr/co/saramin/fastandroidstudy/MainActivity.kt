package kr.co.saramin.fastandroidstudy

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.app.ActivityOptions
import android.util.Pair
import android.view.View


class MainActivity : AppCompatActivity() {

    val MSG_LOG_HELLWORLD = 1000
    val MSG_ACTIVITY_FINISH = 1001
    val MSG_REPEAT_EVERY_5_SEC = 1002

    val REQUEST_SECOND_ACTIVITY = 2000
    val REQUEST_THIRD_ACTIVITY = 2001


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)

        initListener()
//        handlerTests()
    }

    fun initListener() {
        backButton.setOnClickListener { onBackPressed() }
        centerText.setOnClickListener { centerText.text = "Hell World" }
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

//    fun handlerTests() {
//        // Handler 1
//        Handler().postDelayed({
//            Log.v("MainActivity", "Log after 2 second")
//        }, 2000)
//        handler.sendEmptyMessage(MSG_LOG_HELLWORLD)
//        handler.sendEmptyMessageDelayed(MSG_ACTIVITY_FINISH, 10000)
//        handler.sendEmptyMessage(MSG_REPEAT_EVERY_5_SEC)
//    }


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
}
