package bitflyday.com.mobile.application.finjung.presentation.feature.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.viewModels
import bitflyday.com.mobile.application.finjung.R
import bitflyday.com.mobile.application.finjung.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater,container,false).apply {
            viewModel = dashboardViewModel
        }
        binding.toolbar.navigationIcon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_clapperboard_svgrepo_com)
        return binding.root
    }
}