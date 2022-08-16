package com.harunbekcan.sampleandroidproject.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.harunbekcan.sampleandroidproject.BR
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.databinding.BottomSheetLayoutBinding
import com.harunbekcan.sampleandroidproject.databinding.ItemBottomSheetLayoutBinding

class BottomSheetDialog : BottomSheetDialogFragment() {

    var adapter: LastAdapter? = null
    private var titleText: String = ""
    private lateinit var titleTextView: TextView
    var itemClickListener: BottomSheetItemClickListener? = null
    var approveButtonListener: BottomSheetApproveButtonListener? = null
    var bottomSheetAdapterList = ArrayList<Any>()

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val rootView = BottomSheetLayoutBinding.inflate(inflater,container,false)
        initAdapter(rootView)
        titleTextView = rootView.bottomSheetTitleTextView
        titleTextView.text = titleText
        return rootView.root
    }

    companion object {
        val instance: BottomSheetDialog
            get() = BottomSheetDialog()
    }

    private fun initAdapter(rootView:BottomSheetLayoutBinding) {
        adapter = rootView.bottomSheetRecyclerView.let {
            LastAdapter(bottomSheetAdapterList, BR.item)
                .map<BottomSheetModel>(
                    Type<ItemBottomSheetLayoutBinding>(R.layout.item_bottom_sheet_layout).onBind { holder ->
                        val data = holder.binding.item
                        data?.let {
                            holder.binding.languageBottomSheetRadioButton.isClickable = false
                            holder.binding.languageBottomSheetRadioButton.isChecked = it.isSelected

                            holder.binding.container.setOnClickListener {
                                itemClickListener?.bottomSheetItemClick(
                                    holder.binding.item as BottomSheetModel,
                                    holder.layoutPosition
                                )
                            }
                            rootView.approveButton.setOnClickListener {
                                approveButtonListener?.approveItemClick(
                                    holder.binding.item as BottomSheetModel,
                                    holder.layoutPosition
                                )
                            }
                        }
                    }).into(rootView.bottomSheetRecyclerView)
        }
    }

    /** First method init title and bottom sheet type **/
    fun setupSheet(title: String) {
        titleText = title
    }

    /** BottomSheet RecList item listener **/
    interface BottomSheetItemClickListener {
        fun bottomSheetItemClick(item: Any, layoutPosition: Int)
    }

    interface BottomSheetApproveButtonListener {
        fun approveItemClick(item: Any, layoutPosition: Int)
    }
}