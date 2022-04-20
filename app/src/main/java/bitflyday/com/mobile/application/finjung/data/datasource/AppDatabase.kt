package bitflyday.com.mobile.application.finjung.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import bitflyday.com.mobile.application.finjung.data.datasource.account.AccountDao
import bitflyday.com.mobile.application.finjung.data.datasource.category.ItemCategoryDao
import bitflyday.com.mobile.application.finjung.data.datasource.transaction.TransactionItemDao
import bitflyday.com.mobile.application.finjung.data.datasource.account.Account
import bitflyday.com.mobile.application.finjung.data.datasource.receipt.ReceiptDao
import bitflyday.com.mobile.application.finjung.data.datasource.category.ItemCategories
import bitflyday.com.mobile.application.finjung.data.datasource.receipt.Receipt
import bitflyday.com.mobile.application.finjung.data.datasource.transaction.TransactionItem
import bitflyday.com.mobile.application.finjung.utilities.DATABASE_NAME
import bitflyday.com.mobile.application.finjung.utilities.ITEM_CATEGORY_FILENAME
import bitflyday.com.mobile.application.finjung.workers.InsertSimpleAccountDataWorker
import bitflyday.com.mobile.application.finjung.workers.InsertSimpleItemCategoriesDataWorker
import bitflyday.com.mobile.application.finjung.workers.InsertSimpleItemCategoriesDataWorker.Companion.KEY_FILENAME


@Database(entities = [Account::class, Receipt::class, ItemCategories::class, TransactionItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun receiptDao(): ReceiptDao
    abstract fun itemCategoryDao(): ItemCategoryDao
    abstract fun transactionItemDao(): TransactionItemDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val insertSimpleAccountData = OneTimeWorkRequestBuilder<InsertSimpleAccountDataWorker>()
                                .build()

                            val insertSimpleItemCategoryData = OneTimeWorkRequestBuilder<InsertSimpleItemCategoriesDataWorker>()
                                .setInputData(workDataOf(KEY_FILENAME to ITEM_CATEGORY_FILENAME))
                                .build()

                            WorkManager.getInstance(context).enqueue(listOf(insertSimpleAccountData,insertSimpleItemCategoryData))
                        }
                    }
                )
                .build()
        }
    }
}