package bitflyday.com.mobile.application.finjung.presentation.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bitflyday.com.mobile.application.finjung.data.datasource.account.Account
import bitflyday.com.mobile.application.finjung.data.datasource.transaction.TransactionItem
import bitflyday.com.mobile.application.finjung.domain.account.LoadAccountUseCase
import bitflyday.com.mobile.application.finjung.domain.model.ItemTransaction
import bitflyday.com.mobile.application.finjung.domain.transaction.LoadTransactionsUseCase
import bitflyday.com.mobile.application.finjung.result.Result
import bitflyday.com.mobile.application.finjung.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    loadAccountUseCase: LoadAccountUseCase,
    loadTransactionsUseCase: LoadTransactionsUseCase
) : ViewModel() {
    private val simpleIncomeTransactionItem = TransactionItem().apply {
        accountId = 1
        categoryId = 1
        itemName = "Salary of April"
        value = 15963
    }


    init {

    }
    // Expose new UI data when loadSessionsResult changes

    // Account
    val account: StateFlow<Account?> = loadAccountUseCase(Unit).map {
        it.data
    }.stateIn(viewModelScope, SharingStarted.Eagerly, Account())

    //Transactions
    val transactions: StateFlow<List<TransactionItem>?> = loadTransactionsUseCase(Unit).map {
        it.data
    }.stateIn(viewModelScope, SharingStarted.Eagerly, listOf(simpleIncomeTransactionItem))

    val transactions1: StateFlow<List<TransactionItem>> = flow {
        loadTransactionsUseCase(Unit).map { result ->
            emit(result.data?: emptyList<TransactionItem>())
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, listOf(simpleIncomeTransactionItem))

}

data class DashboardUiData(
    val account: Account? = null,
    val listTransactionItem: List<ItemTransaction>? = null
)