package ru.xlwe.singlelivedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val communication: BaseSingleCommunication<EventWrapper.State<String>, EventWrapper.State<String>>
) : ViewModel() {

    private val eventSuccess = EventWrapper.State("success")
    private val eventFail = EventWrapper.State("error")

    fun changeValueSuccess() {
        eventSuccess.setState(false)
        communication.mapSuccess(eventSuccess)
    }

    fun changeValueFail() {
        eventFail.setState(false)
        communication.mapError(eventFail)
    }

    fun observeSuccess(lifecycleOwner: LifecycleOwner, observer: Observer<EventWrapper.State<String>>) {
        communication.observeSuccess(lifecycleOwner, observer)
    }

    fun observeError(lifecycleOwner: LifecycleOwner, observer: Observer<EventWrapper.State<String>>) {
        communication.observeError(lifecycleOwner, observer)
    }
}