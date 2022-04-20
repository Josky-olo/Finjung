package bitflyday.com.mobile.application.finjung.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import bitflyday.com.mobile.application.finjung.data.datasource.AppDatabase
import bitflyday.com.mobile.application.finjung.data.datasource.account.Account
import bitflyday.com.mobile.application.finjung.data.datasource.account.AccountDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class InsertSimpleAccountDataWorker @Inject constructor(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val database = AppDatabase.getInstance(applicationContext)
            database.accountDao().insertAccount(Account())
            Result.success()
        } catch (ex: Exception) {
            Timber.e(ex, "Error Insert Simple Account Data Worker")
            Result.failure()
        }
    }
}