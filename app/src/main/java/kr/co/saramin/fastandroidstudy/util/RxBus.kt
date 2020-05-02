package kr.co.saramin.fastandroidstudy.util

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject

object RxBus {
    private val bus = PublishSubject.create<String>()
    fun post(parameter: String) {
        bus.onNext(parameter)
    }

    fun observe() = bus.observeOn(AndroidSchedulers.mainThread())
}