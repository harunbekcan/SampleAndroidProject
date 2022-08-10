package com.harunbekcan.sampleandroidproject.ui.activity

import android.os.Bundle
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.base.BaseActivity
import com.harunbekcan.sampleandroidproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {}
}