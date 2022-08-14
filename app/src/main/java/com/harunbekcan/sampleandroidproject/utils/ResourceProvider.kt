package com.harunbekcan.sampleandroidproject.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.harunbekcan.sampleandroidproject.R
import javax.inject.Inject

class ResourceProvider @Inject constructor(val context: Context) {

    //String

    fun getTurkishLanguageString() = context.getString(R.string.turkish)
    fun getEnglishLanguageString() = context.getString(R.string.english)
    fun getFrenchLanguageString() = context.getString(R.string.french)


    //Drawable

    fun getLanguageDrawable() = ContextCompat.getDrawable(context,R.drawable.ic_language)
    fun getLogOutDrawable() = ContextCompat.getDrawable(context,R.drawable.ic_logout)
}