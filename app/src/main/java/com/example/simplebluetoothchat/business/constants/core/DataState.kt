package com.example.simplebluetoothchat.business.constants.core

sealed class DataState<T> {

    data class Data<T>(
        val connectionState: ConnectionState = ConnectionState.None,
        val data: T? = null,
    ) : DataState<T>()

    data class Loading<T>(val progressBarState: ProgressBarState = ProgressBarState.Idle) :
        DataState<T>()

}