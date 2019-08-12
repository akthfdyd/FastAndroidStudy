package kr.co.saramin.fastandroidstudy

import android.app.Application
import com.facebook.stetho.Stetho

val TAG = "FastAndroidStudy"

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}