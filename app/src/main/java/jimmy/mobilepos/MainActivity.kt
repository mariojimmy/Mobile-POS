package jimmy.mobilepos

import android.os.Bundle
import androidx.fragment.app.Fragment
import jimmy.mobilepos.base.BaseActivity
import jimmy.mobilepos.ui.dashboard.DashboardFragment
import jimmy.mobilepos.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            toolbar.title = it.title
            openFragment(
                when (it.itemId) {
                    R.id.dashboard -> DashboardFragment()
                    else -> SettingsFragment()
                }
            )
            true
        }
        bottomNavigation.selectedItemId = R.id.dashboard
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}