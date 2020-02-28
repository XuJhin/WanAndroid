package com.xujhin.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.UpdateMode
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Companion.unquoted
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.json
import kotlinx.serialization.modules.EmptyModule
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * @Description: java类作用描述
 * @Author:          xujing
 * @Date:            2020/2/28 0028 14:05
 * @Version:         1.0
 */
class Net {
    companion object {
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    private val contentType = "application/json".toMediaType()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun <T> createService(clz: Class<T>): T {
        return retrofit.create(clz)
    }

}