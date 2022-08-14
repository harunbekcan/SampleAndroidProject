package com.harunbekcan.sampleandroidproject.data

import android.graphics.drawable.Drawable

data class BottomSheetModel(
    val id : Int,
    val image : Drawable?,
    val title : String = "",
    var isSelected : Boolean = false
)