package com.harunbekcan.sampleandroidproject.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.button.MaterialButton
import com.harunbekcan.sampleandroidproject.R

fun Context.showDialog(
    cancelable: Boolean = false,
    cancelableTouchOutside: Boolean = false,
    builderFunction: MaterialDialog.() -> Any,
) {
    MaterialDialog(this).show {
        cancelable(cancelable)
        cancelOnTouchOutside(cancelableTouchOutside)
        setContentView(R.layout.view_custom_dialog)
        builderFunction.invoke(this)
    }
}

fun MaterialDialog.setImage(image: Int?) {
    this.findViewById<ImageView>(R.id.ivPopup).loadImageDrawable(image ?: 0)
    this.findViewById<ImageView>(R.id.ivPopup).isVisible = true
}

fun MaterialDialog.setCloseButton(
    handleClick: () -> Unit = { dismiss() }
) {
    this.findViewById<ImageView>(R.id.ivClose).isVisible = true
    this.findViewById<ImageView>(R.id.ivClose).setOnClickListener {
        handleClick.invoke()
    }


}

@SuppressLint("CutPasteId")
fun MaterialDialog.setMaterialTitle(text: String?) {
    this.findViewById<TextView>(R.id.tvTitle).text = text
    this.findViewById<TextView>(R.id.tvTitle).isVisible = true
}

@SuppressLint("CutPasteId")
fun MaterialDialog.setMessage(text: String?) {
    this.findViewById<TextView>(R.id.tvMessage).text = text
    this.findViewById<TextView>(R.id.tvMessage).isVisible = true
}

@SuppressLint("CutPasteId")
fun MaterialDialog.materialNeutralButton(
    text: String = "Neutral Button",
    handleClick: () -> Unit = {},
) {
    this.findViewById<TextView>(R.id.neutralButton).text = text
    this.findViewById<TextView>(R.id.neutralButton).isVisible = true
    this.findViewById<TextView>(R.id.container).isVisible = false
    this.findViewById<TextView>(R.id.neutralButton).setOnClickListener {
        handleClick()
        dismiss()
    }

}

@SuppressLint("CutPasteId")
fun MaterialDialog.materialNegativeButton(
    text: String = "Negative Button",
    handleClick: () -> Unit = {},
) {
    if (this.findViewById<TextView>(R.id.negativeButton) != null) {
        this.findViewById<TextView>(R.id.negativeButton).text = text
        this.findViewById<TextView>(R.id.negativeButton).isVisible = true
        this.findViewById<TextView>(R.id.neutralButton).isVisible = false
        this.findViewById<TextView>(R.id.negativeButton).setOnClickListener {
            handleClick()
            dismiss()
        }
    }
}

@SuppressLint("CutPasteId")
fun MaterialDialog.materialPositiveButton(
    text: String = "Positive Button",
    handleClick: () -> Unit = {},
) {
    if (this.findViewById<TextView>(R.id.positiveButton) != null) {
        this.findViewById<TextView>(R.id.positiveButton).text = text
        this.findViewById<TextView>(R.id.positiveButton).isVisible = true
        this.findViewById<TextView>(R.id.neutralButton).isVisible = false
        this.findViewById<TextView>(R.id.positiveButton).setOnClickListener {
            handleClick()
            dismiss()
        }
    } else {
        (this.findViewById(R.id.positiveButton) as MaterialButton).setGone()
    }
}