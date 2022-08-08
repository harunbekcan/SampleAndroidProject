package com.harunbekcan.sampleandroidproject.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.harunbekcan.sampleandroidproject.R
import java.text.SimpleDateFormat
import java.util.*

fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this.context)
        .load(imageUrl)
        .error(R.drawable.ic_launcher_background)
        .into(this)
}

fun ImageView.loadRoundedImage(imageUrl: String?) {

    imageUrl?.let {
        if (it.isNotEmpty()) {
            Glide.with(context)
                .load(it)
                .apply(
                    RequestOptions.centerInsideTransform().transform(
                        CenterCrop(),
                        GranularRoundedCorners(14f, 14f, 14f, 14f)
                    )
                )
                .error(R.drawable.ic_launcher_background)
                .into(this)
        }
    }
}

