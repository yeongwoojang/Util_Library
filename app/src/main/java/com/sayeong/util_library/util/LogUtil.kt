package com.sayeong.util_library.util

import android.util.Log

class LogUtil {
    companion object{
        fun info(s : String,msg : String){
            Log.i(s,msg)
        }
    }
}