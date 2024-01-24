package com.example.simplebluetoothchat.business.core

sealed class ProgressBarState{

    object Loading: ProgressBarState()

    object Idle: ProgressBarState()

}