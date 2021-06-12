package jimmy.mobilepos.ui.auth

import `in`.aabhasjindal.otptextview.OTPListener
import android.os.Bundle
import android.view.View
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import jimmy.mobilepos.MainActivity
import jimmy.mobilepos.R
import jimmy.mobilepos.base.BaseActivity
import kotlinx.android.synthetic.main.activity_auth.*
import java.util.concurrent.Executor

class AuthActivity : BaseActivity() {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initOTP()
        initBiometric()
    }

    private fun initOTP() {
        otpView.otpListener = object : OTPListener {
            override fun onInteractionListener() {}
            override fun onOTPComplete(otp: String) {
                finishAndStart<MainActivity>()
            }
        }
    }

    private fun initBiometric() {
        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    finishAndStart<MainActivity>()
                }
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    showMessage(errString.toString())
                }
                override fun onAuthenticationFailed() {}
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.biometric_login_title))
            .setSubtitle(getString(R.string.biometric_login_subtitle))
            .setNegativeButtonText(getString(R.string.cancel))
            .build()
    }

    fun fingerprintLogin(view: View) {
        biometricPrompt.authenticate(promptInfo)
    }
}