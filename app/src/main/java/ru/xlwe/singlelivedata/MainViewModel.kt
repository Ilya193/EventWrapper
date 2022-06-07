package ru.xlwe.singlelivedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val singleCommunication: BaseSingleCommunication<Event.State<String>, Event.State<String>>
) : ViewModel() {

    private val eventSuccess = Event.State("success")
    private val eventFail = Event.State("error")

    fun changeValueSuccess() {
        eventSuccess.setState(false)
        singleCommunication.mapSuccess(eventSuccess)
    }

    fun changeValueFail() {
        eventFail.setState(false)
        singleCommunication.mapError(eventFail)
    }

    fun observeSuccess(lifecycleOwner: LifecycleOwner, observer: Observer<Event.State<String>>) {
        singleCommunication.observeSuccess(lifecycleOwner, observer)
    }

    fun observeError(lifecycleOwner: LifecycleOwner, observer: Observer<Event.State<String>>) {
        singleCommunication.observeError(lifecycleOwner, observer)
    }
}