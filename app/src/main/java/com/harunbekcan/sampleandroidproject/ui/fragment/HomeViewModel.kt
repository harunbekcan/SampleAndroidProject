package com.harunbekcan.sampleandroidproject.ui.fragment

import androidx.lifecycle.ViewModel
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.utils.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val resourceProvider: ResourceProvider) : ViewModel() {

    var bottomSheetLanguageList = ArrayList<BottomSheetModel>()

    fun initBottomSheetLanguageList() {
        bottomSheetLanguageList.add(BottomSheetModel(1, resourceProvider.getLanguageDrawable(), resourceProvider.getTurkishLanguageString()))
        bottomSheetLanguageList.add(BottomSheetModel(2, resourceProvider.getLanguageDrawable(), resourceProvider.getEnglishLanguageString()))
        bottomSheetLanguageList.add(BottomSheetModel(3, resourceProvider.getLanguageDrawable(), resourceProvider.getFrenchLanguageString()))
    }

    fun bottomSheetSelectItem(bottomSheetModel: BottomSheetModel) {
        bottomSheetModel.isSelected = bottomSheetModel.isSelected.not()
    }

    private fun getSelectedItems() = bottomSheetLanguageList.filter { it.isSelected }
    fun getSelectedItemIds() = getSelectedItems().map { it.id }

}