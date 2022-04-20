package bitflyday.com.mobile.application.finjung.data.datasource.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "item_categories"
)
data class ItemCategories(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cate_id")
    val categoryId: Long,

    @ColumnInfo(name = "cate_name")
    val categoryName: String = "unknown",

    @ColumnInfo(name = "cate_Desc")
    val categoryDesc: String = "",
)
