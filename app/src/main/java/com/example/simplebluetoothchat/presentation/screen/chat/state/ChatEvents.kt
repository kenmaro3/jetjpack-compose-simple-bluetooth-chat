package com.example.simplebluetoothchat.presentation.screen.chat.state

import com.example.simplebluetoothchat.business.constants.core.ProgressBarState


sealed class ChatEvents{

    data class UpdateProgressBarState(val value: ProgressBarState) : ChatEvents()

    data class UpdateIsBluetoothOn(val value: Boolean) : ChatEvents()

    data class UpdateInputChat(val value: String) : ChatEvents()

}