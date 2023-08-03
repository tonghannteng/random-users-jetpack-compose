package com.example.randomusers.common

sealed class UiDataState<T> {
    class Loading<T> : UiDataState<T>()
    data class Error<T>(val error: String) : UiDataState<T>()
    data class Loaded<T>(val data: T) : UiDataState<T>()
}
