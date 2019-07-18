package kr.co.saramin.fastandroidstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Int? <- Nullable type. it can be null, so you need 'null check' for use
        // ?. <- safe call, when object is not null
        // ?.let <- run block with 'it' if it is not null
        val backgroundColor: Int? = intent?.extras?.getInt("backgroundColor")
        backgroundColor?.let { layoutContainer.setBackgroundColor(it) }
    }
}
