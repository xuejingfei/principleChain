package com.xjf.principle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.xjf.principle.bean.Request
import com.xjf.principle.interceptors.OneInterceptor
import com.xjf.principle.interceptors.RealInterceptorChain
import com.xjf.principle.interceptors.ThirdInterceptor
import com.xjf.principle.interceptors.TwoInterceptor
import com.xjf.principle.interfaces.Interceptor
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val interceptors = ArrayList<Interceptor>()
        interceptors.add(OneInterceptor())
        interceptors.add(TwoInterceptor())
        interceptors.add(ThirdInterceptor())
        val request = Request()
        request.name = "开始"
        val realInterceptorChain = RealInterceptorChain(interceptors,0, request)
        tv_title.text =  realInterceptorChain.invoke().mName
    }


}
