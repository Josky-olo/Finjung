package bitflyday.com.mobile.application.finjung.presentation.feature.dashboard

import androidx.lifecycle.ViewModel
import bitflyday.com.mobile.application.finjung.domain.model.ItemTransaction
import bitflyday.com.mobile.application.finjung.domain.prefs.OnboardingCompleteActionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(

) : ViewModel() {
//val dashboardUiData: StateFlow<DashboardUiData> =
}

data class DashboardUiData(
    val listTransactionItem: List<ItemTransaction>? = null
)