package com.harunbekcan.sampleandroidproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harunbekcan.sampleandroidproject.R
import com.harunbekcan.sampleandroidproject.base.BaseFragment
import com.harunbekcan.sampleandroidproject.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun prepareView(savedInstanceState: Bundle?) {
    }
}