package bitflyday.com.mobile.application.finjung.domain.transaction

import bitflyday.com.mobile.application.finjung.data.datasource.transaction.TransactionItem
import bitflyday.com.mobile.application.finjung.data.datasource.transaction.TransactionRepository
import bitflyday.com.mobile.application.finjung.di.IoDispatcher
import bitflyday.com.mobile.application.finjung.domain.FlowUseCase
import bitflyday.com.mobile.application.finjung.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoadTransactionsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<Unit, List<TransactionItem>>(dispatcher) {
    override fun execute(parameters: Unit): Flow<Result<List<TransactionItem>>> {
        return transactionRepository.getTransactions().map { Result.Success(it) }
    }
}