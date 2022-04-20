package bitflyday.com.mobile.application.finjung.data.datasource.transaction

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionItemDao {
    @Query("SELECT * FROM TRANSACTION_ITEM")
    fun getTransactions(): Flow<List<TransactionItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactionItem(transactionItem: TransactionItem):Long
}