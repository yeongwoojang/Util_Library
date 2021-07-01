package com.sayeong.util_library.util.network

import android.content.Context
import com.sayeong.util_library.util.network.base.BaseManager
import retrofit2.Call

class RestApiHelper{

    companion object{
        private val TAG = RestApiHelper::class.java.simpleName
        private var instance : RestApiHelper? = null

       fun getInstance() : RestApiHelper =
           instance ?: synchronized(this){
               instance ?: RestApiHelper().also {
                   instance = it
               }
           }
    }

    private var mManagerList : ArrayList<BaseManager> = ArrayList()

    fun init(context : Context){
        init(context,null)
    }

    fun init(context : Context,configPath : String?){
//        ServerUrl.getInstance().init(context,configPath)

//        mManagerList.add()
    }


    fun request(request : RestApiRequest) : Call<Any>{
        //어떤 request가 와도 적절한 Call을 Return 하도록 만들 예정
        val call  = mManagerList[0].request(request)
        return call
    }

}