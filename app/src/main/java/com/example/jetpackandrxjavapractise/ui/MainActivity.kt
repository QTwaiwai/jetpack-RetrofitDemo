package com.example.jetpackandrxjavapractise.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackandrxjavapractise.R
import com.example.jetpackandrxjavapractise.adapter.ApiAdapter
import com.example.jetpackandrxjavapractise.viewmodel.MyViewModel
import com.example.jetpackandrxjavapractise.bean.Story
import com.example.jetpackandrxjavapractise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mApiAdapter: ApiAdapter by lazy { ApiAdapter() }

    private val mViewModel: MyViewModel by lazy { ViewModelProvider(this)[MyViewModel::class.java] }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        iniRv()
        // iniListener()
    }

    private fun iniRv() {
        mBinding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mApiAdapter.apply {

            }
            }
        mViewModel.liveData.observe(this@MainActivity) {
            val mList = (it as MutableList<Story>).toMutableList()
            mApiAdapter.submitList(mList)
        }
    }
}