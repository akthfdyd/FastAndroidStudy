package kr.co.saramin.fastandroidstudy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)
        backButton.setOnClickListener {
            onBackPressed()
        }
        nextButton.setOnClickListener {
            centerText.text = "Welcome to hell"
        }

        backgroundSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layoutContainer.setBackgroundColor(Color.parseColor("#444444"))
            } else {
                layoutContainer.setBackgroundColor(Color.parseColor("#999999"))
            }
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
