package bitflyday.com.mobile.application.finjung.data.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "receipt"
)
data class Receipt(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "receipt_id")
    val receiptId: Long = 0,

    @ColumnInfo(name = "shop_dept_store_name")
    val shopDeptStoreName: String = "unidentifiable",

    @ColumnInfo(name = "shop_dept_store_branch")
    val shopDeptStoreBranch: String = "unidentifiable",

    @ColumnInfo(name = "tax_id")
    val taxId: String = "unidentifiable"
)
