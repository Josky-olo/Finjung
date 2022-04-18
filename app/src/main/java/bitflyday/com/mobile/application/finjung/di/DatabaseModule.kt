package bitflyday.com.mobile.application.finjung.di

import android.content.Context
import bitflyday.com.mobile.application.finjung.data.datasource.account.AccountDao
import bitflyday.com.mobile.application.finjung.data.datasource.AppDatabase
import bitflyday.com.mobile.application.finjung.data.datasource.dao.ItemCategoryDao
import bitflyday.com.mobile.application.finjung.data.datasource.dao.SpendingItemDao
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
    fun provideItemCategoryDao(appDatabase: AppDatabase): ItemCategoryDao {
        return appDatabase.itemCategoryDao()
    }

    @Provides
    fun provideSpendingItemDao(appDatabase: AppDatabase): SpendingItemDao {
        return appDatabase.spendingItemDao()
    }
}