package ru.xlwe.singlelivedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

interface CommunicationSuccess<T> {
    fun mapSuccess(data: T)
    fun observeSuccess(lifecycleOwner: LifecycleOwner, observer: Observer<T>)
}

interface CommunicationFail<R> {
    fun mapError(data: R)
    fun observeError(lifecycleOwner: LifecycleOwner, observer: Observer<R>)
}

class BaseSingleCommunication<T: Any, R: Any> :
    CommunicationSuccess<T>, CommunicationFail<R> {

    private val liveDataSuccess = MutableLiveData<T>()
    private val liveDataFail = MutableLiveData<R>()

    override fun mapSuccess(data: T) {
        liveDataSuccess.value = data
    }

    override fun observeSuccess(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        liveDataSuccess.observe(lifecycleOwner, observer)
    }

    override fun mapError(data: R) {
        liveDataFail.value = data
    }

    override fun observeError(lifecycleOwner: LifecycleOwner, observer: Observer<R>) {
        liveDataFail.observe(lifecycleOwner, observer)
    }
}

interface Event<T> {
    fun getContentOrNot(): T?

    open class Single<T>(protected var data: T) : Event<T> {
        protected var enabled = false

        override fun getContentOrNot(): T? {
            return if (enabled) null else {
                enabled = true
                data
            }
        }
    }

    open class State<T>(data: T) : Single<T>(data) {
        fun setState(value: Boolean) {
            enabled = value
        }
    }

    class Change<T>(data: T) : State<T>(data) {
        fun setValue(value: T) {
            data = value
        }
    }
}