package com.example.simplebluetoothchat.business.constants.core

sealed class ProgressBarState{

    object Loading: ProgressBarState()

    object Idle: ProgressBarState()

}