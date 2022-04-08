package bitflyday.com.mobile.application.finjung.domain.prefs

import bitflyday.com.mobile.application.finjung.data.datasource.AppDatabase
import bitflyday.com.mobile.application.finjung.data.prefs.PreferenceStorage
import bitflyday.com.mobile.application.finjung.di.IoDispatcher
import bitflyday.com.mobile.application.finjung.domain.FlowUseCase
import bitflyday.com.mobile.application.finjung.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class OnboardingCompletedUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<Unit, Boolean>(dispatcher) {
    override fun execute(parameters: Unit): Flow<Result<Boolean>> =
        preferenceStorage.onboardingCompleted.map { Result.Success(it) }
}