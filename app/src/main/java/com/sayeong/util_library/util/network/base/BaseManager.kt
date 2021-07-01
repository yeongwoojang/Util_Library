package com.sayeong.util_library.util.network.base

import com.sayeong.util_library.util.network.RestApiRequest
import retrofit2.Call


open abstract class BaseManager {
    abstract fun getUrlKey(): String

    abstract fun checkRequest(request: RestApiRequest): Boolean

    abstract fun request(request: RestApiRequest): Call<Any>

    fun getUrl() :Any?{
        return null
    }

}