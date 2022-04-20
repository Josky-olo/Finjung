package bitflyday.com.mobile.application.finjung.data.datasource.transaction

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class TransactionRepository @Inject constructor(
    private val transactionItemDao: TransactionItemDao
) {
    fun getTransactions() = transactionItemDao.getTransactions()
}