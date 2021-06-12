package jimmy.mobilepos.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jimmy.mobilepos.R
import jimmy.mobilepos.data.models.Transaction
import jimmy.mobilepos.ui.settings.PaymentMethods
import kotlinx.android.synthetic.main.transaction_item_layout.view.*

class TransactionsAdapter(private val dataSet: List<Transaction>) :
    RecyclerView.Adapter<TransactionsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val number: TextView = view.cardNumber
        val icon: ImageView = view.icon
        val amount: TextView = view.amount

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.transaction_item_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = dataSet[position]
        val context = holder.itemView.context
        holder.number.text = context.getString(R.string.card_number, transaction.card)
        holder.amount.text = context.getString(R.string.amount_sar, transaction.amount)
        holder.icon.setImageResource(
            when (transaction.method) {
                PaymentMethods.VISA -> R.drawable.ic_visa
                PaymentMethods.MASTER -> R.drawable.ic_master
                PaymentMethods.MADA -> R.drawable.ic_mada
                PaymentMethods.APPLE -> R.drawable.ic_apple_pay
            }
        )
    }

    override fun getItemCount() = dataSet.size

}
