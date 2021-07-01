package com.sayeong.util_library.util

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatViewInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.sayeong.util_library.R

class PopupUtil constructor(context: Context?) {
    companion object {
        private var instance: PopupUtil? = null
        private lateinit var mContext: Context

        fun getInstance(context: Context?): PopupUtil {
            return instance ?: synchronized(this) {
                instance ?: PopupUtil(context).also {
                    instance = it
                }
            }
        }
    }

    private var popupView : ConstraintLayout? = null
    private var mWindowManager: WindowManager? = null

    init {
        context?.let {
            mContext = it
            setPopupView(it)
            mWindowManager =
                mContext.applicationContext?.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        }
    }


    fun test(xml : Int, activity: AppCompatActivity){
        val view : ConstraintLayout = activity.findViewById(xml)
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        popupView?.layoutParams = layoutParams
        val t = getPopupView()
        view.addView(t)

        t.requestFocus()

    }
    private fun setPopupView(context: Context){
        popupView = ConstraintLayout(context)
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        popupView?.layoutParams = layoutParams
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun showPopup() {
        val view = getPopupView()
        popupView?.addView(view)
        val layoutParams = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.CENTER
        }
        mWindowManager?.addView(popupView, layoutParams)
    }

    private fun getPopupView(): View {
        return LayoutInflater.from(mContext).inflate(R.layout.general_popup, null)
    }
}

