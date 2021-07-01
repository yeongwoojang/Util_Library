package com.sayeong.util_library.util.network

import com.sayeong.util_library.util.LogUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class CommonCallback<T> : Callback<T>{
    companion object{
        val TAG : String = CommonCallback::class.java.simpleName
    }
    override fun onResponse(call: Call<T>, response: Response<T>) {
        LogUtil.debug(TAG,"onResponse is called")
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        LogUtil.debug(TAG,"onFailure : ${t.message}")

    }
}
