package com.example.simplebluetoothchat.presentation.screen.chat.main.state

import com.example.simplebluetoothchat.business.constants.core.ProgressBarState
import com.example.simplebluetoothchat.business.domain.DeviceData

sealed class MainEvents {

    data class UpdateProgressBarState(val value: ProgressBarState) : MainEvents()

    data class UpdateShouldBluetoothStartScan(val value: Boolean) : MainEvents()

    data class UpdateShouldMakeDeviceVisible(val value: Boolean) : MainEvents()

    data class UpdatePairedDevice(val list: ArrayList<DeviceData>) : MainEvents()

    data class AddToSearchedDevice(val item: DeviceData) : MainEvents()

    data class UpdateSearchedDevice(val list: ArrayList<DeviceData>) : MainEvents()

    data class UpdateIsBluetoothOn(val value: Boolean) : MainEvents()

}