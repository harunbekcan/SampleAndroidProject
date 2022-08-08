package com.harunbekcan.sampleandroidproject.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.annotation.Nullable
import com.blankj.utilcode.util.SPUtils
import com.google.gson.Gson

fun <T> addDataModelSharedPref(key: String, data: T?) {
    val gson = Gson()
    if (data == null)
        throw RuntimeException("Data can not be null")

    val json = gson.toJson(data)

    if (json != null) {
        SPUtils.getInstance().apply {
            put(key, json)
        }
    } else
        throw RuntimeException("Data can not be null")
}

@Nullable
fun <T> retrieveDataModelSharedPref(key: String, clazz: Class<T>): T? {
    val gson = Gson()
    if (SPUtils.getInstance().contains(key)) {

        val json = SPUtils.getInstance().getString(key)

        return gson.fromJson(json, clazz)

    } else {
        return null
    }
}

fun Context.copyToClipboard(text: CharSequence) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
}