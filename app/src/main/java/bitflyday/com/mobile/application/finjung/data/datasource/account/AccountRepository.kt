package bitflyday.com.mobile.application.finjung.data.datasource.account

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountRepository @Inject constructor(
private val accountDao: AccountDao
) {
fun getAccounts() = accountDao.getAccounts()
}