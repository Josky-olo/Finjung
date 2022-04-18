package bitflyday.com.mobile.application.finjung.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import bitflyday.com.mobile.application.finjung.data.datasource.entities.ItemCategories


@Dao
interface ItemCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemCategories(itemCategories:ItemCategories):Long
}