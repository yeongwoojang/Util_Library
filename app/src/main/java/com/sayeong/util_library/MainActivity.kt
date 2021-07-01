package com.sayeong.util_library

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.sayeong.util_library.util.LogUtil
import com.sayeong.util_library.util.PopupUtil

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val info : List<ActivityManager.AppTask> =  manager.appTasks
        for(task in info){
            LogUtil.info("TAG","TopActivity : ${task.taskInfo.topActivity?.className}")
            PopupUtil.getInstance(this).test(R.id.test,activity = this)
        }
//        PopupUtil.getInstance(this).showPopup()
    }
}