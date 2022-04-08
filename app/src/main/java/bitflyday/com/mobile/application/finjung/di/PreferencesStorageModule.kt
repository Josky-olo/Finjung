package bitflyday.com.mobile.application.finjung.di

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.preferencesDataStore
import bitflyday.com.mobile.application.finjung.data.prefs.DataStoragePreferenceStorage
import bitflyday.com.mobile.application.finjung.data.prefs.PreferenceStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PreferencesStorageModule {

    val Context.dataStore by preferencesDataStore(
        name = DataStoragePreferenceStorage.PREFS_NAME,
        produceMigrations = { context ->
            listOf(
                SharedPreferencesMigration(
                    context, DataStoragePreferenceStorage.PREFS_NAME
                )
            )
        }
    )

@Singleton
@Provides
fun providePreferenceStorage(@ApplicationContext context: Context): PreferenceStorage =
    DataStoragePreferenceStorage(context.dataStore)
}