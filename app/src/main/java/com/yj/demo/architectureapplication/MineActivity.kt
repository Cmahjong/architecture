package com.yj.demo.architectureapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yj.demo.architectureapplication.ui.mine.MineFragment

class MineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MineFragment.newInstance())
                    .commitNow()
        }
    }

}
