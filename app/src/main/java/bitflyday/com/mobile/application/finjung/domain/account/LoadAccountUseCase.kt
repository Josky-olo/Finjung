package bitflyday.com.mobile.application.finjung.domain.account

import bitflyday.com.mobile.application.finjung.data.datasource.account.Account
import bitflyday.com.mobile.application.finjung.data.datasource.account.AccountRepository
import bitflyday.com.mobile.application.finjung.di.IoDispatcher
import bitflyday.com.mobile.application.finjung.domain.FlowUseCase
import bitflyday.com.mobile.application.finjung.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoadAccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Account>(dispatcher) {
    override fun execute(parameters: Unit): Flow<Result<Account>> {
        return accountRepository.getAccount().map { Result.Success(it) }
    }
}