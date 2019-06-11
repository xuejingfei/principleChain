package com.xjf.principle.interceptors

import android.util.Log
import com.xjf.principle.bean.Response
import com.xjf.principle.interfaces.Interceptor

/**
 * description: 自定义一个拦截器
 * @author xuejingfei
 * create at 19-6-11
 */

class ThirdInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        request.name =  request.name + "ThirdInterceptor"
        Log.d("xjf",request.name)
        val response = Response("thirdResponse")
        Log.d("xjf",response.mName)
        return response
    }
}