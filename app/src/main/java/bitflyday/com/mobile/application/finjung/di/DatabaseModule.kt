package bitflyday.com.mobile.application.finjung.di

import android.content.Context
import bitflyday.com.mobile.application.finjung.data.datasource.AccountDao
import bitflyday.com.mobile.application.finjung.data.datasource.AppDatabase
import bitflyday.com.mobile.application.finjung.data.datasource.ItemCategoryDao
import bitflyday.com.mobile.application.finjung.data.datasource.SpendingItemDao
import bitflyday.com.mobile.application.finjung.data.prefs.PreferenceStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
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