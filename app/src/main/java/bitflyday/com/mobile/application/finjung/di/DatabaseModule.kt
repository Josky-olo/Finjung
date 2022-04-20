package bitflyday.com.mobile.application.finjung.di

import android.content.Context
import bitflyday.com.mobile.application.finjung.data.datasource.account.AccountDao
import bitflyday.com.mobile.application.finjung.data.datasource.AppDatabase
import bitflyday.com.mobile.application.finjung.data.datasource.category.ItemCategoryDao
import bitflyday.com.mobile.application.finjung.data.datasource.receipt.ReceiptDao
import bitflyday.com.mobile.application.finjung.data.datasource.transaction.TransactionItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideAccountDao(appDatabase: AppDatabase): AccountDao {
        return appDatabase.accountDao()
    }

    @Provides
    fun provideReceiptDao(appDatabase: AppDatabase): ReceiptDao {
        return appDatabase.receiptDao()
    }

    @Provides
    fun provideItemCategoryDao(appDatabase: AppDatabase): ItemCategoryDao {
        return appDatabase.itemCategoryDao()
    }

    @Provides
    fun provideTransactionItemDao(appDatabase: AppDatabase): TransactionItemDao {
        return appDatabase.transactionItemDao()
    }
}