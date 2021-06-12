package jimmy.mobilepos.ui.settings

import androidx.lifecycle.ViewModel
import jimmy.mobilepos.data.repositories.SettingsRepository
import jimmy.mobilepos.ui.settings.PaymentMethods.*

class SettingsViewModel(private val repository: SettingsRepository) : ViewModel() {

    val isVisaEnabled get() = repository.isMethodEnabled(VISA)
    val isMasterEnabled get() = repository.isMethodEnabled(MASTER)
    val isMadaEnabled get() = repository.isMethodEnabled(MADA)
    val isAppleEnabled get() = repository.isMethodEnabled(APPLE)

    fun setVisaEnabled(isEnabled: Boolean) { repository.setMethodEnabled(VISA, isEnabled) }
    fun setMasterEnabled(isEnabled: Boolean) { repository.setMethodEnabled(MASTER, isEnabled) }
    fun setMadaEnabled(isEnabled: Boolean) { repository.setMethodEnabled(MADA, isEnabled) }
    fun setAppleEnabled(isEnabled: Boolean) { repository.setMethodEnabled(APPLE, isEnabled) }

}