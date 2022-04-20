package bitflyday.com.mobile.application.finjung.data.datasource.receipt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import bitflyday.com.mobile.application.finjung.data.datasource.receipt.Receipt

@Dao
interface ReceiptDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(receipt: Receipt):Long
}