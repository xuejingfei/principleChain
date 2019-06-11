package com.xjf.principle.interfaces

import com.xjf.principle.bean.Request
import com.xjf.principle.bean.Response

/**
 * description: 拦截器接口
 * @author xuejingfei
 * create at 19-6-11
 */

public interface Interceptor {
    fun intercept(chain:Chain): Response

    //链状
    interface Chain {
        fun request():Request

        fun proceed(request:Request):Response
    }
}