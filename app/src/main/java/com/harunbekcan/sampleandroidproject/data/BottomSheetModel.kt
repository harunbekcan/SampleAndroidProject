package com.harunbekcan.sampleandroidproject.data

import android.graphics.drawable.Drawable

data class BottomSheetModel(
    val image : Drawable?,
    val title : String = "",
    var isChecked : Boolean = false
)