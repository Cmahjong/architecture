package com.yj.demo.architectureapplication.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yj.demo.architectureapplication.R
import com.yj.demo.architectureapplication.util.onClick
import com.yj.demo.service.response.WeatherResponse
import kotlinx.android.synthetic.main.mine_fragment.*

class MineFragment : Fragment() {

    companion object {
        fun newInstance() = MineFragment()
    }

    private lateinit var viewModel: MineViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        print("onCreateView")
        return inflater.inflate(R.layout.mine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        print("onActivityCreated")
        viewModel = ViewModelProviders.of(this).get(MineViewModel::class.java)
        viewModel.weatherResponse.observe(this, Observer<WeatherResponse> {
            message.text = "地点：${it.heWeather6?.get(0)?.basic?.parentCity
                    ?: ""};天气：${it.heWeather6?.get(0)?.now?.condTxt
                    ?: ""};温度：${it.heWeather6?.get(0)?.now?.tmp ?: ""}"
        })
        bt_weather.onClick {
            viewModel.refreshData(this)
        }

    }
}
