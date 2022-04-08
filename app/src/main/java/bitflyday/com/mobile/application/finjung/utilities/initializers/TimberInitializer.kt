package bitflyday.com.mobile.application.finjung.utilities.initializers

import android.content.Context
import androidx.startup.Initializer
import bitflyday.com.mobile.application.finjung.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}