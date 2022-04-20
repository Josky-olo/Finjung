package bitflyday.com.mobile.application.finjung.data.datasource.account

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
    var userName: String = "finny",

    @ColumnInfo(name = "first_name")
    var firstName: String = "Finjung",

    @ColumnInfo(name = "last_name")
    var lastName: String = "",
)