package bitflyday.com.mobile.application.finjung.presentation

import android.content.Intent
import android.os.Bundle
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import bitflyday.com.mobile.application.finjung.presentation.feature.onboarding.OnboardingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import bitflyday.com.mobile.application.finjung.presentation.LaunchNavigationAction.NavigateToOnboardingAction
import bitflyday.com.mobile.application.finjung.presentation.LaunchNavigationAction.NavigateToMainActivityAction
import timber.log.Timber


@AndroidEntryPoint
class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LaunchViewModel by viewModels()
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.launchDestination.collect { action ->
                    when (action) {
                        is NavigateToMainActivityAction -> startActivity(
                            Intent(this@LauncherActivity, MainActivity::class.java)
                        )
                        is NavigateToOnboardingAction -> startActivity(
                            Intent(this@LauncherActivity, OnboardingActivity::class.java)
                        )
                    }
                    finish()
                }
            }
        }
    }
}