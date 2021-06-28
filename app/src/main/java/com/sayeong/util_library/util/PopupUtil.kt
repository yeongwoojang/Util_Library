package com.sayeong.util_library.util

import android.content.Context
import android.view.WindowManager

class PopupUtil constructor(context: Context?) {
    companion object {
        private var instance: PopupUtil? = null
        private lateinit var context: Context

        fun getInstance(context: Context?): PopupUtil {
          return  instance ?: synchronized(this) {
                instance ?: PopupUtil(context).also {
                    instance = it
                }
            }
        }
    }

    private var mWindowManager : WindowManager? = null
    init {
        LogUtil.info("POPUPUTIL","Singleton Test")
        mWindowManager = context?.applicationContext?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    }


}