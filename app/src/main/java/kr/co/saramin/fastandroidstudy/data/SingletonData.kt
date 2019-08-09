package kr.co.saramin.fastandroidstudy.data

import android.annotation.SuppressLint

class SingletonData {

    var intVariable: Int? = null
    var stringVariable: String? = null

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: SingletonData? = null
        fun getInstance(): SingletonData {
            if (instance == null) {
                instance = SingletonData()
            }
            return instance as SingletonData
        }
    }
}