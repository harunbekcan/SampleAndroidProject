package com.harunbekcan.sampleandroidproject.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingUtils {

    @JvmStatic
    @BindingAdapter("load_image")
    fun loadImage(view: ImageView, imageUrl: String?) {
        imageUrl?.let {
            view.loadImage(it)
        }
    }

    @JvmStatic
    @BindingAdapter("loadImageDrawable")
    fun loadImageDrawable(view: ImageView, imageUrl: Int?) {
        imageUrl?.let {
            view.loadImageDrawable(it)
        }
    }
}