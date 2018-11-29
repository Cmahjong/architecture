package com.yj.demo.architectureapplication.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.uber.autodispose.lifecycle.autoDisposable
import com.yj.demo.architectureapplication.App
import com.yj.demo.architectureapplication.util.threadSwitch
import com.yj.demo.service.response.WeatherResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MineViewModel : ViewModel() {
    val weatherResponse: LiveData<WeatherResponse>
        get() = _weatherResponse
    private val _weatherResponse = MutableLiveData<WeatherResponse>()
    fun refreshData(fragment: MineFragment) {
        (fragment.activity?.application as App).client
                .weatherService
                .weatherDetail("成都", "8b65421c62124b92adbba623356047a6")
                .threadSwitch()
                .autoDisposable(AndroidLifecycleScopeProvider.from(fragment))
                ?.subscribe(object : Observer<WeatherResponse> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: WeatherResponse) {
                        _weatherResponse.value = t
                    }

                    override fun onError(e: Throwable) {
                    }
                })
    }
}
