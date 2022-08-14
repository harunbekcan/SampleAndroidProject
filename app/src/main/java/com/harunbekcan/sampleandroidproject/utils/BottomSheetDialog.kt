package com.harunbekcan.sampleandroidproject.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.harunbekcan.sampleandroidproject.BR
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.databinding.ItemBottomSheetLayoutBinding

class BottomSheetDialog : BottomSheetDialogFragment() {

    var adapter: LastAdapter? = null
    private var titleText: String = ""
    private lateinit var titleTextView: TextView
    var listener: BottomSheetListener? = null
    private lateinit var recyclerView: RecyclerView
    var bottomSheetAdapterList = ArrayList<Any>()

    @Nullable
    override fun onCreateView(
        @NonNull inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    companion object {
        val instance: BottomSheetDialog
            get() = BottomSheetDialog()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.bottomSheetRecyclerView)
        titleTextView = view.findViewById(R.id.bottomSheetTitleTextView)
        titleTextView.text = titleText
        initAdapter()
    }

    private fun initAdapter() {
        adapter = view?.findViewById<RecyclerView>(R.id.bottomSheetRecyclerView)?.let {
            LastAdapter(bottomSheetAdapterList,BR.item)
                .map<BottomSheetModel>(
                    Type<ItemBottomSheetLayoutBinding>(R.layout.item_bottom_sheet_layout).onBind { holder ->
                        holder.binding.container.setOnClickListener {
                            listener?.bottomSheetItemClick(
                                holder.binding.item as BottomSheetModel,
                                holder.layoutPosition
                            )
                        }
                    }).into(recyclerView)
        }
    }

    /** First method init title and bottom sheet type **/
    fun setupSheet(title: String) {
        titleText = title
    }

    /** BottomSheet RecList item listener **/
    interface BottomSheetListener {
        fun bottomSheetItemClick(item: Any, layoutPosition: Int)
    }
}