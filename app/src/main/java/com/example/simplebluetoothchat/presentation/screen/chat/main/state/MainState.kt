package com.example.simplebluetoothchat.presentation.screen.chat.main.state

import com.example.simplebluetoothchat.business.constants.core.ProgressBarState
import com.example.simplebluetoothchat.business.domain.DeviceData

data class MainState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val pairedDevices:ArrayList<DeviceData> = arrayListOf(),
    val searchedDevices:ArrayList<DeviceData> = arrayListOf(),
    val isBluetoothOn:Boolean = false,
    val shouldBluetoothStartScan:Boolean = false,
    val shouldMakeDeviceVisible:Boolean = false,
)