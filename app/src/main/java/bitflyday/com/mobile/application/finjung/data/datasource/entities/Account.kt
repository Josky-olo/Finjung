package bitflyday.com.mobile.application.finjung.data.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "account"
)
data class Account(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "account_id")
    val accountId: Long = 0,

    @ColumnInfo(name = "user_name")
    val userName: String = "finny",

    @ColumnInfo(name = "first_name")
    val firstName: String = "Finjung",

    @ColumnInfo(name = "last_name")
    val lastName: String = "",
)