package bitflyday.com.mobile.application.finjung.presentation.feature.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import bitflyday.com.mobile.application.finjung.R
import bitflyday.com.mobile.application.finjung.utilities.doOnApplyWindowInserts
import bitflyday.com.mobile.application.finjung.utilities.inTransaction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val container: FrameLayout = findViewById(R.id.fragment_container)
        container.doOnApplyWindowInserts { v, insets, padding ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(top = padding.top + systemBars.top)
        }
        if (savedInstanceState == null) {
            supportFragmentManager.inTransaction {
                add(R.id.fragment_container, OnboardingFragment())
            }
        }
    }
}