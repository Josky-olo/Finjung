package bitflyday.com.mobile.application.finjung.domain.prefs


import bitflyday.com.mobile.application.finjung.data.prefs.PreferenceStorage
import bitflyday.com.mobile.application.finjung.di.IoDispatcher
import bitflyday.com.mobile.application.finjung.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class OnboardingCompleteActionUseCase @Inject constructor(
private val preferenceStorage: PreferenceStorage,
@IoDispatcher dispatcher: CoroutineDispatcher
): UseCase<Boolean, Unit>(dispatcher) {
    override suspend fun execute(parameters: Boolean) {
        preferenceStorage.completeOnboarding(parameters)
    }
}