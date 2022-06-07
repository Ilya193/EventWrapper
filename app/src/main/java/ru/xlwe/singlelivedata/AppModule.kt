package ru.xlwe.singlelivedata

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(
            get()
        )
    }

    factory<BaseSingleCommunication<Event.State<String>, Event.State<String>>> {
        BaseSingleCommunication<Event.State<String>, Event.State<String>>()
    }
}