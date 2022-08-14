package com.harunbekcan.sampleandroidproject.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.harunbekcan.sampleandroidproject.utils.BottomSheetDialog

abstract class BaseFragment<VDB : ViewDataBinding> : Fragment() {

    lateinit var binding: VDB
    lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), container, false)
        return binding.root
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(savedInstanceState)
    }

    abstract fun prepareView(savedInstanceState: Bundle?)

    @Suppress("SameParameterValue")
    fun showBottomSheet(
        context: Context,
        title: Int,
        listener: BottomSheetDialog.BottomSheetListener,
        approveButtonListener : BottomSheetDialog.BottomSheetApproveButtonListener
    ) {
        bottomSheetDialog = BottomSheetDialog.instance.apply {
            setupSheet(context.getString(title))
            this.listener = listener
            this.approveButtonListener = approveButtonListener
        }.also {
            it.show(childFragmentManager, getString(title))
        }
    }
}