package com.xujhin.myapplication.base.entity

import kotlinx.serialization.Serializable

/**
 * @Description: java类作用描述
 * @Author:          xujing
 * @Date:            2020/2/28 0028 15:06
 * @Version:         1.0
 */
@Serializable
data class BaseData<T>(
    val errorCode: Int?,
    val data: T?,
    val errorMsg: String?
)