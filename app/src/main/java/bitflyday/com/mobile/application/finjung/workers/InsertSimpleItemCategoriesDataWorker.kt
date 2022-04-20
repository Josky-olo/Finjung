package bitflyday.com.mobile.application.finjung.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import bitflyday.com.mobile.application.finjung.data.datasource.AppDatabase
import bitflyday.com.mobile.application.finjung.data.datasource.category.ItemCategories
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class InsertSimpleItemCategoriesDataWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val itemCategoryType = object : TypeToken<List<ItemCategories>>() {}.type
                        val itemCategoryList: List<ItemCategories> = Gson().fromJson(jsonReader,itemCategoryType)

                        val database = AppDatabase.getInstance(applicationContext)
                        database.itemCategoryDao().insertItemCategories(itemCategoryList)
                        Result.success()
                    }
                }
            }else{
                Timber.i("Error Insert database - no valid filename")
                Result.failure()
            }
        } catch (ex: Exception) {
            Timber.e(ex, "Error Insert Simple Item Category Data Worker")
            Result.failure()
        }

    }

    companion object {
        const val KEY_FILENAME = "ITEM_CATEGORY_FILENAME"
    }
}