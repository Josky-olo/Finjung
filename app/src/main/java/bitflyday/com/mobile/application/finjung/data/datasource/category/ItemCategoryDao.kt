package bitflyday.com.mobile.application.finjung.data.datasource.category

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import bitflyday.com.mobile.application.finjung.data.datasource.account.Account


@Dao
interface ItemCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemCategories(itemCategories: List<ItemCategories>)

}