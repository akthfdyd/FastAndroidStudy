package kr.co.saramin.fastandroidstudy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)

        backButton.setOnClickListener { onBackPressed() }

        nextButton.setOnClickListener { centerText.text = "Welcome to hell" }

//        //1
//        centerText.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                v as TextView
//                v.text = "Hell World!"
//            }
//        })

//        //2
//        centerText.setOnClickListener(fun(it: View) {
//            centerText.text = "Hell World"
//        })

        //3
        centerText.setOnClickListener { centerText.text = "Hell World" }



        backgroundSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                layoutContainer.setBackgroundColor(Color.parseColor("#444444"))
            } else {
                layoutContainer.setBackgroundColor(Color.parseColor("#999999"))
            }
        }

        //1
        profileImage.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
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
                return true
            }
        })
//
//        //2
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

        //3
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

            /*when (조건) {
                1 -> function1()
                2 -> function2()
                else -> function3()
            }*/

            true
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
