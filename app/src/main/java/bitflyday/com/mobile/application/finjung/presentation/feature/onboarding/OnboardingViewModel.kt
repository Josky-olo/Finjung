package bitflyday.com.mobile.application.finjung.presentation.feature.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitflyday.com.mobile.application.finjung.data.datasource.account.AccountDao
import bitflyday.com.mobile.application.finjung.data.datasource.account.AccountRepository
import bitflyday.com.mobile.application.finjung.domain.account.LoadAccountsUseCase
import bitflyday.com.mobile.application.finjung.domain.prefs.OnboardingCompleteActionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val onboardingCompleteActionUseCase: OnboardingCompleteActionUseCase,
    private val loadAccountsUseCase: LoadAccountsUseCase
): ViewModel() {
    private val _navigationActions = Channel<OnboardingNavigationAction>(Channel.CONFLATED)
    val navigationAction = _navigationActions.receiveAsFlow()

    fun getStartedClick() {
        viewModelScope.launch {
            onboardingCompleteActionUseCase(true)
            _navigationActions.send(OnboardingNavigationAction.NavigateToMainScreen)
        }
    }


}
sealed class OnboardingNavigationAction{
object NavigateToMainScreen: OnboardingNavigationAction()
}
