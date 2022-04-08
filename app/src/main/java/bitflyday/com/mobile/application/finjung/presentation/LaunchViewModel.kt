package bitflyday.com.mobile.application.finjung.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitflyday.com.mobile.application.finjung.domain.prefs.OnboardingCompletedUseCase
import bitflyday.com.mobile.application.finjung.presentation.LaunchNavigationAction.NavigateToOnboardingAction
import bitflyday.com.mobile.application.finjung.presentation.LaunchNavigationAction.NavigateToMainActivityAction
import bitflyday.com.mobile.application.finjung.result.Result.Loading
import bitflyday.com.mobile.application.finjung.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    onboardingCompletedUseCase: OnboardingCompletedUseCase
) : ViewModel() {
    val launchDestination = onboardingCompletedUseCase(Unit).map { result ->
        if (result.data == false) {
            NavigateToOnboardingAction
        } else {
            NavigateToMainActivityAction
        }
    }.stateIn(viewModelScope, Eagerly, Loading)
}

sealed class LaunchNavigationAction {
    object NavigateToOnboardingAction : LaunchNavigationAction()
    object NavigateToMainActivityAction : LaunchNavigationAction()
}
