package com.xjf.principle.interceptors

import com.xjf.principle.bean.Request
import com.xjf.principle.bean.Response
import com.xjf.principle.interfaces.Interceptor
import java.lang.RuntimeException

/**
 * description: 责任链具体实现
 * @author xuejingfei
 * create at 19-6-11
 */
class RealInterceptorChain(interceptors: List<Interceptor>, index: Int, request: Request) : Interceptor.Chain {
    var mInterceptors = interceptors
    var mIndex = index
    var mRequest = request

    override fun request(): Request {
        return mRequest
    }

    override fun proceed(request: Request): Response {
        if (mIndex > mInterceptors.size - 1) {
           throw RuntimeException("超出拦截器限制")
        }

        val next = RealInterceptorChain(mInterceptors,mIndex+1,request)
        val interceptor = mInterceptors[mIndex]
        return interceptor.intercept(next)
    }

    public fun invoke():Response {
        return proceed(mRequest)
    }

}