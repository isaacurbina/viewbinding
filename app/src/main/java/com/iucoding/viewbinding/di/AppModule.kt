package com.iucoding.viewbinding.di

import com.iucoding.viewbinding.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    // ViewModel for MainActivity
    viewModelOf(::MainViewModel)
}
