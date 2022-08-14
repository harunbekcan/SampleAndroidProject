package com.harunbekcan.sampleandroidproject.ui.fragment

import androidx.lifecycle.ViewModel
import com.harunbekcan.sampleandroidproject.data.BottomSheetModel
import com.harunbekcan.sampleandroidproject.utils.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (val resourceProvider : ResourceProvider): ViewModel() {
    var bottomSheetLanguageList = ArrayList<BottomSheetModel>()

    fun initBottomSheetLanguageList(){
        bottomSheetLanguageList.add(BottomSheetModel(
            resourceProvider.getLanguageDrawable(), resourceProvider.getTurkishLanguageString()))
        bottomSheetLanguageList.add(BottomSheetModel(
            resourceProvider.getLanguageDrawable(), resourceProvider.getEnglishLanguageString()))
        bottomSheetLanguageList.add(BottomSheetModel(
            resourceProvider.getLanguageDrawable(), resourceProvider.getFrenchLanguageString()))
    }
}