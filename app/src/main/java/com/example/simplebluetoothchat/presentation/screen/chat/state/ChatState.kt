package com.example.simplebluetoothchat.presentation.screen.chat.state

import com.example.simplebluetoothchat.business.constants.core.ProgressBarState

data class ChatState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val isBluetoothOn:Boolean = true,
    val chatInput:String = "",
)