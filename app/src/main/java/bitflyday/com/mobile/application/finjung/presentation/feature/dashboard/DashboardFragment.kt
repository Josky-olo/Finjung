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
import bitflyday.com.mobile.application.finjung.utilities.showToast
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false).apply {
            viewModel = dashboardViewModel
        }
        setToastColors()
        showToast(MotionToastStyle.ERROR, "Hello world", "How are you.", requireActivity())
        binding.toolbar.navigationIcon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_clapperboard_svgrepo_com)
        return binding.root
    }
    private fun setToastColors() {
            MotionToast.setSuccessColor(R.color.custom_success_color)
            MotionToast.setErrorColor(R.color.Red)
            MotionToast.setDeleteColor(R.color.custom_delete_color)
            MotionToast.setWarningColor(R.color.custom_warning_color)
            MotionToast.setInfoColor(R.color.Primary)
            MotionToast.setSuccessBackgroundColor(R.color.success_bg_color)
            MotionToast.setErrorBackgroundColor(R.color.error_bg_color)
            MotionToast.setDeleteBackgroundColor(R.color.delete_bg_color)
            MotionToast.setWarningBackgroundColor(R.color.warning_bg_color)
            MotionToast.setInfoBackgroundColor(R.color.info_bg_color)
    }
}