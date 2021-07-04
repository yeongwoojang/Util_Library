package com.sayeong.util_library.util

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
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

    private var popupView: ConstraintLayout? = null
    private var mWindowManager: WindowManager? = null

    init {
        context?.let {
            mContext = it
            setPopupView(it)
            mWindowManager =
                mContext.applicationContext?.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        }
    }


    fun showPopup(xml: Int, activity: AppCompatActivity) {
        val view: LinearLayout = activity.findViewById(xml)
        val popupItemView = getPopupView()

        popupView?.addView(popupItemView)
        view.removeAllViews()
        view.addView(popupView)
        val animation : Animation = AnimationUtils.loadAnimation(mContext,R.anim.zoom_in)
        view.startAnimation(animation)

    }

    private fun setPopupView(context: Context) {
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        popupView = ConstraintLayout(mContext)
        popupView?.layoutParams = layoutParams
    }

    private fun getPopupView(): View {
        return LayoutInflater.from(mContext).inflate(R.layout.general_popup, null)
    }
}

;