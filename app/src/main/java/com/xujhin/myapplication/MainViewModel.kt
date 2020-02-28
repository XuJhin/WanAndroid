package com.xujhin.myapplication

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xujhin.myapplication.base.BaseViewModel
import com.xujhin.myapplication.base.entity.BannerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @Description: java类作用描述
 * @Author:          xujing
 * @Date:            2020/2/28 0028 13:57
 * @Version:         1.0
 */
class MainViewModel : BaseViewModel() {
    companion object {
        const val TAG = "MainViewModel"
    }

    private val mainRepository: MainRepository by lazy {
        MainRepository()
    }
    val bannerLiveData = MutableLiveData<MutableList<BannerEntity>>()
    fun getBanner() {
        launchIO({
            val result = mainRepository.getBanner()
            if (result.data != null) {
                postData(result.data)
            }
        }, {
            Log.e(TAG, it.toString())
        }, {})
    }

    private fun postData(data: MutableList<BannerEntity>) {
        bannerLiveData.postValue(data)
    }

}