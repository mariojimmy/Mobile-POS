package jimmy.mobilepos.data.repositories

import jimmy.mobilepos.data.local.Preferences
import jimmy.mobilepos.ui.settings.PaymentMethods

class SettingsRepository(private val preferences: Preferences) {

    fun isMethodEnabled(paymentMethods: PaymentMethods) =
        preferences.getBoolean(paymentMethods.name)

    fun setMethodEnabled(paymentMethods: PaymentMethods, enabled: Boolean) =
        preferences.setBoolean(paymentMethods.name, enabled)

}