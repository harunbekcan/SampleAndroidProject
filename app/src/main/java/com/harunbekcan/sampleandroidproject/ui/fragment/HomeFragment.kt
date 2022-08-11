package com.harunbekcan.sampleandroidproject.ui.fragment

import android.os.Bundle
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.base.BaseFragment
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.databinding.FragmentHomeBinding
import com.harunbekcan.sampleandroidproject.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), BottomSheetDialog.BottomSheetListener {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun prepareView(savedInstanceState: Bundle?) {
        openBottomSheetButtonListener()
        openPopUpButtonListener()
    }

    private fun openPopUpButtonListener() {
        binding.openPopUpWindowButton.setOnClickListener {
            requireContext().showDialog {
                setImage(R.drawable.ic_logout)
                setMaterialTitle(getString(R.string.pop_up_title))
                materialPositiveButton(getString(R.string.positive_button)) { dismiss() }
                materialNegativeButton(getString(R.string.negative_button)) { dismiss() }
                setCloseButton { dismiss() }
            }
        }
    }

    private fun openBottomSheetButtonListener() {
        binding.openBottomSheetButton.setOnClickListener {
            showBottomSheet(requireContext(), R.string.bottom_sheet_title, this)
            bottomSheetDialog.bottomSheetAdapterList.add(BottomSheetModel(R.drawable.ic_launcher_background, getString(R.string.android)))
            bottomSheetDialog.bottomSheetAdapterList.add(BottomSheetModel(R.drawable.ic_launcher_background, getString(R.string.android)))
            bottomSheetDialog.bottomSheetAdapterList.add(BottomSheetModel(R.drawable.ic_launcher_background, getString(R.string.android)))
        }
    }

    override fun bottomSheetItemClick(item: Any, layoutPosition: Int) {
        bottomSheetDialog.dismiss()
    }
}