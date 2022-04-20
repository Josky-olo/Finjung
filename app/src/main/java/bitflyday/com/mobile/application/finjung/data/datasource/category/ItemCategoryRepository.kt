package bitflyday.com.mobile.application.finjung.data.datasource.category

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ItemCategoryRepository @Inject constructor(
    private val itemCategoryDao: ItemCategoryDao
) {

}