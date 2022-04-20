package bitflyday.com.mobile.application.finjung.data.datasource.account

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class AccountRepository @Inject constructor(
private val accountDao: AccountDao
) {
fun getAccount() = accountDao.getAccount()
}