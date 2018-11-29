package com.yj.demo.architectureapplication

import androidx.multidex.MultiDexApplication
import com.yj.demo.service.Client

/**
 * desc:Application
 * time: 2018/11/29
 * @author yinYin
 */
class App : MultiDexApplication() {
    /** 初始化网络服务器 */
    val client:Client by lazy {
        Client()
    }
    override fun onCreate() {
        super.onCreate()
    }

}