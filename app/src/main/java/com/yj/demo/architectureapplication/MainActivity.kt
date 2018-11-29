package com.yj.demo.architectureapplication

import android.content.Intent
import android.os.Bundle
import com.yj.demo.architectureapplication.util.onClick
import com.yj.demo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.onClick {
            startActivity(Intent(this@MainActivity, MineActivity::class.java))
        }
    }


}




