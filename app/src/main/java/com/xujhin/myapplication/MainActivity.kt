package com.xujhin.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initData()
        initViewAndEvent()
    }

    private fun initViewAndEvent() {
        btn_request.setOnClickListener { initData() }
    }

    private fun initData() {
        mainViewModel.getBanner()
        mainViewModel.bannerLiveData.observe(this,
            Observer {
                it.map { entity ->
                    Log.e("main", "title${entity.title}")
                }
            })
    }
}
