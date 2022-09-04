package com.harunbekcan.sampleandroidproject.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.blankj.utilcode.util.LogUtils
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.base.BaseFragment
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.databinding.FragmentHomeBinding
import com.harunbekcan.sampleandroidproject.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(),
    BottomSheetDialog.BottomSheetItemClickListener,
    BottomSheetDialog.BottomSheetApproveButtonListener {

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
            showBottomSheet(requireContext(), R.string.languages, this, this)
            viewModel.bottomSheetLanguageList.forEach {
                bottomSheetDialog.bottomSheetAdapterList.add(
                    it.copy()
                )
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun bottomSheetItemClick(item: Any, layoutPosition: Int) {
        if (item is BottomSheetModel) {
            viewModel.bottomSheetSelectItem(item)
            bottomSheetDialog.adapter?.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun approveItemClick(view: View) {
        viewModel.bottomSheetLanguageList.forEach {
            it.isSelected = (bottomSheetDialog.bottomSheetAdapterList.find { language -> (language as BottomSheetModel).id == it.id } as BottomSheetModel).isSelected
        }
//        viewModel.bottomSheetLanguageList.forEachIndexed {index, bottomSheetModel ->
//            bottomSheetModel.isSelected = (bottomSheetDialog.bottomSheetAdapterList[index] as BottomSheetModel).isSelected
//        }
        bottomSheetDialog.dismiss()
    }
}