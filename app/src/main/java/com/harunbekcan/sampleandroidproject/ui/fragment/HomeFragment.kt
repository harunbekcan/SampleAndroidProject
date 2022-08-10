package com.harunbekcan.sampleandroidproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.base.BaseFragment
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.databinding.FragmentHomeBinding
import com.harunbekcan.sampleandroidproject.utils.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), BottomSheetDialog.BottomSheetListener {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun prepareView(savedInstanceState: Bundle?) {
        openBottomSheetClicked()
    }

    private fun openBottomSheetClicked() {
        binding.openBottomSheetButton.setOnClickListener {
            showBottomSheet(requireContext(), R.string.bottom_sheet_title, this)
            bottomSheetDialog.bottomSheetAdapterList.add(BottomSheetModel(R.drawable.ic_launcher_background,getString(R.string.android)))
            bottomSheetDialog.bottomSheetAdapterList.add(BottomSheetModel(R.drawable.ic_launcher_background,getString(R.string.android)))
            bottomSheetDialog.bottomSheetAdapterList.add(BottomSheetModel(R.drawable.ic_launcher_background,getString(R.string.android)))
        }
    }

    override fun bottomSheetItemClick(item: Any, layoutPosition: Int) {
        bottomSheetDialog.dismiss()
    }
}