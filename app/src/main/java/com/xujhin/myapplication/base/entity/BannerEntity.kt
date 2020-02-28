package com.xujhin.myapplication.base.entity

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

/**
 * @Description: java类作用描述
 * @Author:          xujing
 * @Date:            2020/2/28 0028 15:47
 * @Version:         1.0
 */
@Serializable
class BannerEntity(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    @Transient val name:String?="",
    val type: Int,
    val url: String
)