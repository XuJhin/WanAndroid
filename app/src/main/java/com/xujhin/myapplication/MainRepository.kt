package com.xujhin.myapplication

import com.xujhin.myapplication.api.HomerService
import com.xujhin.myapplication.base.entity.BannerEntity
import com.xujhin.myapplication.base.entity.BaseData
import com.xujhin.net.Net

/**
 * @Description: java类作用描述
 * @Author:          xujing
 * @Date:            2020/2/28 0028 14:38
 * @Version:         1.0
 */
class MainRepository {

    private val net: Net by lazy {
        Net()
    }
    private val homerService: HomerService by lazy {
        net.createService(HomerService::class.java)
    }

    suspend fun getBanner():BaseData<MutableList<BannerEntity>> {
       return homerService.getBanner()
    }
}