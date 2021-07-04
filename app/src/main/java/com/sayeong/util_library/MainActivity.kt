package com.sayeong.util_library

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.sayeong.util_library.util.PopupUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        bt_test.setOnClickListener {
            PopupUtil.getInstance(this).showPopup(R.id.test,activity = this)
        }
    }
}