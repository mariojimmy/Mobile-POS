package jimmy.mobilepos.ui.auth

import android.os.Bundle
import android.view.View
import jimmy.mobilepos.R
import jimmy.mobilepos.base.BaseActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginUser(view: View) {
        start<AuthActivity>()
    }

}