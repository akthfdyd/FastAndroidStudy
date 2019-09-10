package kr.co.saramin.fastandroidstudy

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        backButton.setOnClickListener { onBackPressed() }

        loginButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, PostListActivity::class.java)
            startActivity(intent)
            finish()
        }

        val idTextWatcher = object : TextWatcher {
            var textTemp = ""

            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val nowText = s.toString().trim()

                if (textTemp == nowText) return

                textTemp = nowText

                launch {
                    delay(1000)

                    if (nowText != textTemp) return@launch

                    when {
                        count == 0 -> warningTextView.text = "Cannot be empty"
                        count > 20 -> warningTextView.text =
                            "You can make your ID 20 characters or less"
                        else -> warningTextView.text = ""
                    }
                }
            }

        }

        idEditText.addTextChangedListener(idTextWatcher)

    }
}
