package com.xujhin.myapplication.api

import com.xujhin.myapplication.base.entity.BannerEntity
import com.xujhin.myapplication.base.entity.BaseData
import retrofit2.http.*

/**
 * @Description: java类作用描述
 * @Author:          xujing
 * @Date:            2020/2/28 0028 14:48
 * @Version:         1.0
 */
interface HomerService {
    @GET(BANNER)
    suspend fun getBanner(): BaseData<MutableList<BannerEntity>>
}
