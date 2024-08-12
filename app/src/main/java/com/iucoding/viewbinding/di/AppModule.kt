package com.iucoding.viewbinding.di

import com.iucoding.viewbinding.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    // ViewModel for MainActivity
    viewModelOf(::MainViewModel)
    single { Dispatchers.IO }
}
