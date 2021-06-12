package jimmy.mobilepos.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import jimmy.mobilepos.R
import kotlinx.android.synthetic.main.fragment_settings.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : Fragment(), CompoundButton.OnCheckedChangeListener {

    private val viewModel: SettingsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        visaSwitch.isChecked = viewModel.isVisaEnabled
        masterSwitch.isChecked = viewModel.isMasterEnabled
        madaSwitch.isChecked = viewModel.isMadaEnabled
        appleSwitch.isChecked = viewModel.isAppleEnabled

        visaSwitch.setOnCheckedChangeListener(this)
        masterSwitch.setOnCheckedChangeListener(this)
        madaSwitch.setOnCheckedChangeListener(this)
        appleSwitch.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            R.id.masterSwitch -> viewModel.setMasterEnabled(isChecked)
            R.id.visaSwitch -> viewModel.setVisaEnabled(isChecked)
            R.id.madaSwitch -> viewModel.setMadaEnabled(isChecked)
            R.id.appleSwitch -> viewModel.setAppleEnabled(isChecked)
        }
    }

}