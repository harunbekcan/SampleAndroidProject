package com.harunbekcan.sampleandroidproject.ui.fragment

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.base.BaseFragment
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.databinding.FragmentHomeBinding
import com.harunbekcan.sampleandroidproject.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), BottomSheetDialog.BottomSheetListener {

    override fun getLayoutId(): Int = R.layout.fragment_home

    private val viewModel: HomeViewModel by viewModels()

    override fun prepareView(savedInstanceState: Bundle?) {
        openBottomSheetButtonListener()
        openPopUpButtonListener()
        viewModel.initBottomSheetLanguageList()
    }

    private fun openPopUpButtonListener() {
        binding.openPopUpWindowButton.setOnClickListener {
            requireContext().showDialog {
                setImage(viewModel.resourceProvider.getLogOutDrawable())
                setMaterialTitle(getString(R.string.pop_up_title))
                materialPositiveButton(getString(R.string.positive_button)) { dismiss() }
                materialNegativeButton(getString(R.string.negative_button)) { dismiss() }
                setCloseButton { dismiss() }
            }
        }
    }

    private fun openBottomSheetButtonListener() {
        binding.openBottomSheetButton.setOnClickListener {
            showBottomSheet(requireContext(), R.string.languages, this)
            bottomSheetDialog.bottomSheetAdapterList.addAll(viewModel.bottomSheetLanguageList)
        }
    }

    override fun bottomSheetItemClick(item: Any, layoutPosition: Int) {
        bottomSheetDialog.dismiss()
    }
}