package jimmy.mobilepos.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jimmy.mobilepos.R
import jimmy.mobilepos.data.models.Transaction
import jimmy.mobilepos.ui.settings.PaymentMethods
import jimmy.mobilepos.ui.settings.PaymentMethods.MASTER
import jimmy.mobilepos.ui.settings.PaymentMethods.VISA
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_dashboard, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        transactionsRecycler.adapter =
            TransactionsAdapter(
                listOf(
                    Transaction(MASTER, "2436", "233.50"),
                    Transaction(MASTER, "9918", "150.00"),
                    Transaction(VISA, "0293", "2034.00"),
                    Transaction(MASTER, "4495", "1854.50"),
                    Transaction(VISA, "2734", "654.00"),
                    Transaction(VISA, "5061", "788.50"),

                    )
            )
    }

}