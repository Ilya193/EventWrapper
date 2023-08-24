package ru.xlwe.singlelivedata

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(
            get()
        )
    }

    factory<BaseSingleCommunication<EventWrapper.State<String>, EventWrapper.State<String>>> {
        BaseSingleCommunication<EventWrapper.State<String>, EventWrapper.State<String>>()
    }
}