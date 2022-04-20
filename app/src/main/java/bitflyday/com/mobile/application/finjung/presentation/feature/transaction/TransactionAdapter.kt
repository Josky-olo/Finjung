package bitflyday.com.mobile.application.finjung.presentation.feature.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bitflyday.com.mobile.application.finjung.databinding.ViewTransactionSpendingBinding
import bitflyday.com.mobile.application.finjung.domain.model.ItemTransaction

class TransactionAdapter(
    private val lifecycleOwner: LifecycleOwner
): ListAdapter<ItemTransaction,TransactionViewHolder>(TransactionDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ViewTransactionSpendingBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ).apply {
            lifecycleOwner = this@TransactionAdapter.lifecycleOwner
        }
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.binding.itemTransaction = getItem(position)
        holder.binding.executePendingBindings()
    }
}
class TransactionViewHolder(
    internal val binding:ViewTransactionSpendingBinding
):RecyclerView.ViewHolder(binding.root)

object TransactionDiff : DiffUtil.ItemCallback<ItemTransaction>() {
    override fun areItemsTheSame(oldItem: ItemTransaction, newItem: ItemTransaction): Boolean {
        // We don't have to compare the userEvent id because it matches the session id.
        return oldItem.transaction.transactionId == newItem.transaction.transactionId
    }

    override fun areContentsTheSame(oldItem: ItemTransaction, newItem: ItemTransaction): Boolean {
        return oldItem == newItem
    }
}