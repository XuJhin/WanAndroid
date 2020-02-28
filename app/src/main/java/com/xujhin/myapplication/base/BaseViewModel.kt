package com.xujhin.myapplication.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*


/**
 * @Description: java类作用描述
 * @Author:          xujing
 * @Date:            2020/2/28 0028 15:36
 * @Version:         1.0
 */
open class BaseViewModel : ViewModel() {

    fun launchIO(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(e: Throwable) -> Unit = {},             // 默认空实现，可根据具体情况变化
        finallyBlock: suspend CoroutineScope.() -> Unit = {}
    ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                tryCatch(tryBlock, catchBlock, finallyBlock)
            }
        }
    }

    /**
     * @param tryBlock 尝试执行的挂起代码块
     * @param catchBlock 捕获异常的代码块 "协程对Retrofit的实现在失败、异常时没有onFailure的回调而是直接已Throwable的形式抛出"
     * @param finallyBlock finally代码块
     */
    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(e: Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                tryBlock()
            } catch (e: Throwable) {
                catchBlock(e)
            } finally {
                finallyBlock()
            }
        }
    }


    fun cancel() {
        if (viewModelScope.isActive) {
            viewModelScope.cancel()
        }
    }
}