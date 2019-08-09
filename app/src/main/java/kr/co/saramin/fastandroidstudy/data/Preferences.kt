package kr.co.saramin.fastandroidstudy.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

@SuppressLint("ApplySharedPref")
class Preferences private constructor() {

    init {
        instance = this
    }

    var saveDataString: String
        get() = preferences?.getString("saveDataString", "") ?: ""
        set(userName) {
            preferences!!.edit().putString("saveDataString", userName).commit()
        }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: Preferences? = null

        @SuppressLint("StaticFieldLeak")
        private var mContext: Context? = null

        private var preferences: SharedPreferences? = null

        fun getInstance(context: Context?): Preferences {
            if (instance == null) {
                instance = Preferences()
            }
            if (context != null) {
                mContext = context
                if (preferences == null) {
                    preferences = PreferenceManager
                        .getDefaultSharedPreferences(context)
                }
            }
            return instance as Preferences
        }

    }

}
