package com.iucoding.viewbinding.viewmodel

import androidx.lifecycle.ViewModel
import com.iucoding.viewbinding.model.HoursItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    suspend fun fetchData(): Flow<List<HoursItem>> {
        return flow {
            val hoursItems = listOf(
                HoursItem(
                    name = "Isaac",
                    hours = 80,
                    country = "MX"
                ),
                HoursItem(
                    name = "Erika",
                    hours = 78,
                    country = "HR"
                ),
                HoursItem(
                    name = "Marek",
                    hours = 76,
                    country = "CH"
                ),
                HoursItem(
                    name = "Julian",
                    hours = 75,
                    country = "AR"
                ),
                HoursItem(
                    name = "Daisy",
                    hours = 74,
                    country = "CN"
                )
            )
            emit(hoursItems)
        }.flowOn(dispatcher)
    }
}
