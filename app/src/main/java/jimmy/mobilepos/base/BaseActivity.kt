package jimmy.mobilepos.base

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    inline fun <reified T : BaseActivity> start() =
        startActivity(Intent(this, T::class.java))

    inline fun <reified T : BaseActivity> finishAndStart() {
        finishAffinity()
        start<T>()
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}