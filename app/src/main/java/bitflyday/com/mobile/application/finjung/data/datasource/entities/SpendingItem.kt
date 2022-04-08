package bitflyday.com.mobile.application.finjung.data.datasource.entities

import androidx.room.*

@Entity(
    tableName = "spending_item",
    foreignKeys = [
        ForeignKey(entity = Account::class, parentColumns = ["account_id"], childColumns = ["account_id"]),
        ForeignKey(entity = ItemCategories::class, parentColumns = ["id"], childColumns = ["cate_id"])
    ],
    indices = [Index("cate_id")]
)
data class SpendingItem(
    @ColumnInfo(name = "account_id") val accountId: Long,
    @ColumnInfo(name = "cate_id") val categoryId: String,
    @ColumnInfo(name = "item_name") val itemName: String,
    @ColumnInfo(name = "spend_type") val spendType: String,
    val value: Long = 0,
    val qty: Int = 0,
    val ownership: String = "me",
    @ColumnInfo(name = "spend_date") val spendDate: Long = System.currentTimeMillis(),
    val detail: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var spendingId: Long = 0
}
