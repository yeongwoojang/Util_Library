package com.sayeong.util_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sayeong.util_library.util.PopupUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PopupUtil.getInstance(this)
    }
}