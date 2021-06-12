package jimmy.mobilepos.data.local

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("wassma-capital", Context.MODE_PRIVATE)

    fun setBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return preferences.getBoolean(key, false)
    }

}