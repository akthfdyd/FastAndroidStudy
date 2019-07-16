package kr.co.saramin.fastandroidstudy

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val MSG_LOG_HELLWORLD = 1000
    val MSG_ACTIVITY_FINISH = 1001
    val MSG_REPEAT_EVERY_5_SEC = 1002


    // Handler 2
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


    // Handler 3
//    private val activity = WeakReference<MainActivity>(this)
//    private val handler = MyHandler(activity)
//
//    class MyHandler(private val activity: WeakReference<MainActivity>) : Handler() {
//        override fun handleMessage(msg: Message) {
//            when (msg.what) {
//                activity.get()?.MSG_LOG_HELLWORLD -> Log.v("MainActivity", "hell world")
//                activity.get()?.MSG_ACTIVITY_FINISH -> activity.get()?.onBackPressed()
////                activity.get()?.MSG_REPEAT_EVERY_5_SEC -> activity.get()?.toastMessage()
//            }
//        }
//    }

    fun toastMessage() {
        Toast.makeText(this, "Developers try exit the Hell", Toast.LENGTH_SHORT).show()
        handler.sendEmptyMessageDelayed(MSG_REPEAT_EVERY_5_SEC, 5000)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)

        backButton.setOnClickListener { onBackPressed() }

        nextButton.setOnClickListener { centerText.text = "Welcome to hell" }

//        // OnClickListener 1
//        centerText.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                v as TextView
//                v.text = "Hell World!"
//            }
//        })

//        // OnClickListener 2
//        centerText.setOnClickListener(fun(it: View) {
//            centerText.text = "Hell World"
//        })

        // OnClickListener 3
        centerText.setOnClickListener { centerText.text = "Hell World" }



        backgroundSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                layoutContainer.setBackgroundColor(Color.parseColor("#444444"))
            } else {
                layoutContainer.setBackgroundColor(Color.parseColor("#999999"))
            }
        }

//        // OnTouchListener 1
//        profileImage.setOnTouchListener(object : View.OnTouchListener {
//            override fun onTouch(v: View, event: MotionEvent): Boolean {
//                when (event.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        centerText.text = "Don't touch my face"
//                    }
//                    MotionEvent.ACTION_MOVE -> {
//                        centerText.text = "No, no.. do not rub"
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        centerText.text = "OK, don't bother me again"
//                    }
//                }
//                return true
//            }
//        })
//
//        // OnTouchListener 2
//        profileImage.setOnTouchListener(fun(view: View, event: MotionEvent): Boolean {
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> {
//                    centerText.text = "Don't touch my face"
//                }
//                MotionEvent.ACTION_MOVE -> {
//                    centerText.text = "No, no.. do not rub"
//                }
//                MotionEvent.ACTION_UP -> {
//                    centerText.text = "OK, don't bother me again"
//                }
//            }
//            return true
//        })

        // OnTouchListener 3
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

//            when (조건) {
//                1 -> function1()
//                2 -> function2()
//                else -> function3()
//            }

            true
        }


        // Handler 1
        Handler().postDelayed({
            Log.v("MainActivity", "Log after 2 second")
        }, 2000)

        handler.sendEmptyMessage(MSG_LOG_HELLWORLD)
        handler.sendEmptyMessageDelayed(MSG_ACTIVITY_FINISH, 10000)
        handler.sendEmptyMessage(MSG_REPEAT_EVERY_5_SEC)
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
