package com.harunbekcan.sampleandroidproject.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.blankj.utilcode.util.LogUtils
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.base.BaseFragment
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.databinding.FragmentHomeBinding
import com.harunbekcan.sampleandroidproject.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), BottomSheetDialog.BottomSheetListener,BottomSheetDialog.BottomSheetApproveButtonListener {

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
            showBottomSheet(requireContext(), R.string.languages, this,this)
            bottomSheetDialog.bottomSheetAdapterList.addAll(viewModel.bottomSheetLanguageList)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun bottomSheetItemClick(item: Any, layoutPosition: Int) {
        if (item is BottomSheetModel) {
            viewModel.bottomSheetSelectItem(item)
            bottomSheetDialog.adapter?.notifyDataSetChanged()
            LogUtils.d("fff",viewModel.bottomSheetLanguageList.toString())
        }
    }

    override fun approveItemClick(item: Any, layoutPosition: Int) {
       viewModel.getSelectedItemIds()
        LogUtils.d("fff1",viewModel.getSelectedItemIds().toString())
        bottomSheetDialog.dismiss()
    }
}