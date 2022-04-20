package bitflyday.com.mobile.application.finjung.data.datasource.transaction

import androidx.room.*
import bitflyday.com.mobile.application.finjung.data.datasource.account.Account
import bitflyday.com.mobile.application.finjung.data.datasource.category.ItemCategories
import bitflyday.com.mobile.application.finjung.data.datasource.receipt.Receipt

@Entity(
    tableName = "transaction_item",
    foreignKeys = [
        ForeignKey(entity = Account::class, parentColumns = ["account_id"], childColumns = ["account_id"]),
        ForeignKey(entity = Receipt::class, parentColumns = ["receipt_id"], childColumns = ["receipt_id"]),
        ForeignKey(entity = ItemCategories::class, parentColumns = ["cate_id"], childColumns = ["cate_id"])
    ],
    indices = [Index("cate_id")]
)
data class TransactionItem(
    @ColumnInfo(name = "account_id") var accountId: Long=0,
    @ColumnInfo(name = "cate_id") var categoryId: Long=0,
    @ColumnInfo(name = "item_name") var itemName: String="anonymous",
    @ColumnInfo(name = "transaction_types") val transactionTypes: String="Income",
    @ColumnInfo(name = "input_types") val inputTypes: String = "record",
    @ColumnInfo(name = "receipt_id") val receiptId: String = "",
    var value: Long = 0,
    val qty: Int = 1,
    val ownership: String = "me",
    @ColumnInfo(name = "transaction_time") val transactionTime: Long = System.currentTimeMillis(),
    val remark: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    var transactionId: Long = 0
}
