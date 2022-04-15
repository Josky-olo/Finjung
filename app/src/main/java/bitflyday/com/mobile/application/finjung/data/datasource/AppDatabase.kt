package bitflyday.com.mobile.application.finjung.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import bitflyday.com.mobile.application.finjung.data.datasource.entities.Account
import bitflyday.com.mobile.application.finjung.data.datasource.entities.ItemCategories
import bitflyday.com.mobile.application.finjung.data.datasource.entities.Receipt
import bitflyday.com.mobile.application.finjung.data.datasource.entities.SpendingItem
import bitflyday.com.mobile.application.finjung.utilities.DATABASE_NAME
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking

@Database(entities = [Account::class,Receipt::class,ItemCategories::class,SpendingItem::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun itemCategoryDao(): ItemCategoryDao
    abstract fun spendingItemDao(): SpendingItemDao

    companion object{
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return instance?: synchronized(this){
                    instance?: buildDatabase(context).also{instance = it}
            }
        }

        private fun buildDatabase(context: Context):AppDatabase{
                return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .addCallback(
                        object : RoomDatabase.Callback(){
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                val database = getInstance(context)
                                runBlocking {
                                    database.accountDao().insertAccount(Account())
                                    database.itemCategoryDao().insertItemCategories(ItemCategories())
                                }
                            }
                        }
                    )
                    .build()
        }
    }
}