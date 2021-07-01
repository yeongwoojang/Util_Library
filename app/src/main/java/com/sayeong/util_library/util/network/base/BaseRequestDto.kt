package com.sayeong.util_library.util.network.base

import com.sayeong.util_library.util.network.ItemString
import java.io.Serializable

abstract class BaseRequestDto : Serializable {
    private var mQueryMap: HashMap<String, String> = HashMap<String, String>()

    fun buildQuery(): HashMap<String, String> {
        return mQueryMap
    }

    protected fun querySet(query: ItemString) {
        query.apply {
            if (mItemName.isNotEmpty() && mValue.isNotEmpty()) {
                mQueryMap[mItemName] = mValue
            }
        }
    }
}