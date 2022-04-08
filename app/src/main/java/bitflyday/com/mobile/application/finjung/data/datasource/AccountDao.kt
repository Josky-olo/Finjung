package bitflyday.com.mobile.application.finjung.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import bitflyday.com.mobile.application.finjung.data.datasource.entities.Account

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account:Account):Long
}