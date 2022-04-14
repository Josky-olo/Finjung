package bitflyday.com.mobile.application.finjung.utilities

import android.app.Activity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import bitflyday.com.mobile.application.finjung.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


inline fun Fragment.launchAndRepeatWithViewLifecycle(
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: suspend CoroutineScope.() -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(minActiveState) {
            block()
        }
    }
}

fun showToast(style: MotionToastStyle, title: String, message: String, activity: Activity) {
    MotionToast.createColorToast(
        activity, title,
        message,
        style,
        MotionToast.GRAVITY_BOTTOM,
        MotionToast.ToastDuration.LONG_DURATION,
        ResourcesCompat.getFont(activity, R.font.helvetica_regular)
    )
  }