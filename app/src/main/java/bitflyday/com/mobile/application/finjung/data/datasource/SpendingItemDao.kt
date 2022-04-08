package bitflyday.com.mobile.application.finjung.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import bitflyday.com.mobile.application.finjung.data.datasource.entities.SpendingItem

@Dao
interface SpendingItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpendingItem(spendingItem:SpendingItem):Long
}