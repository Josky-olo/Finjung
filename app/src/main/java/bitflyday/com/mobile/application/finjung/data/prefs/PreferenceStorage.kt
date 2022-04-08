package bitflyday.com.mobile.application.finjung.data.prefs

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import bitflyday.com.mobile.application.finjung.data.prefs.DataStoragePreferenceStorage.PreferencesKeys.PREF_ONBOARDING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

interface PreferenceStorage {
    suspend fun completeOnboarding(complete: Boolean)
    val onboardingCompleted: Flow<Boolean>
}

@Singleton
class DataStoragePreferenceStorage @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : PreferenceStorage {
    companion object {
        const val PREFS_NAME = "finjung"
    }

    object PreferencesKeys {
        val PREF_ONBOARDING = booleanPreferencesKey("pref_onboarding")
    }

    override suspend fun completeOnboarding(complete: Boolean) {
        dataStore.edit {
            it[PREF_ONBOARDING] = complete
        }
    }

    override val onboardingCompleted: Flow<Boolean>
        get() = dataStore.data.map { it[PREF_ONBOARDING] ?: false }
}