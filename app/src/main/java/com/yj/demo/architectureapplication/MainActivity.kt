package com.yj.demo.architectureapplication

import android.os.Bundle
import android.widget.Button
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.uber.autodispose.lifecycle.autoDisposable
import com.yj.demo.base.BaseActivity
import com.yj.demo.service.response.WeatherResponse
import io.reactivex.ObservableTransformer
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weather_button.onClick {
            (this@MainActivity.application as App).client
                    .weatherService
                    .weatherDetail("成都", "8b65421c62124b92adbba623356047a6")
                    .compose(threadSwitch())
                    .autoDisposable(AndroidLifecycleScopeProvider.from(this))
                    ?.subscribe(object : Observer<WeatherResponse> {
                        override fun onComplete() {

                        }

                        override fun onSubscribe(d: Disposable) {
                        }

                        override fun onNext(t: WeatherResponse) {
                            tv_content.text=t.heWeather6?.get(0)?.now?.condTxt?:""
                        }

                        override fun onError(e: Throwable) {
                        }
                    })
        }
    }

    private fun <T> threadSwitch(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
    }
}

private fun Button.onClick(function: () -> Unit) {
    this.setOnClickListener {
        function()
    }
}
