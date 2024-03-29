package com.example.simplebluetoothchat.presentation.screen.chat.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.simplebluetoothchat.business.constants.core.ProgressBarState
import com.example.simplebluetoothchat.business.domain.DeviceData
import com.example.simplebluetoothchat.presentation.screen.chat.main.state.MainEvents
import com.example.simplebluetoothchat.presentation.screen.chat.main.state.MainState

class MainViewModel : ViewModel() {

    val TAG = "AppDebug MainViewModel"

    val state: MutableState<MainState> = mutableStateOf(MainState())


    fun onTriggerEvent(event: MainEvents) {
        when (event) {
            is MainEvents.UpdateShouldMakeDeviceVisible -> {
                updateShouldMakeDeviceVisible(value = event.value)
            }
            is MainEvents.UpdateShouldBluetoothStartScan -> {
                updateShouldBluetoothStartScan(value = event.value)
            }
            is MainEvents.AddToSearchedDevice -> {
                addToSearchedDevice(item = event.item)
            }
            is MainEvents.UpdateProgressBarState -> {
                updateProgressBarState(value = event.value)
            }
            is MainEvents.UpdatePairedDevice -> {
                updatePairedDevice(list = event.list)
            }
            is MainEvents.UpdateSearchedDevice -> {
                updateSearchedDevice(list = event.list)
            }
            is MainEvents.UpdateIsBluetoothOn -> {
                updateIsBluetoothOn(value = event.value)
            }
        }
    }

    private fun updateShouldBluetoothStartScan(value: Boolean) {
        state.value = state.value.copy(shouldBluetoothStartScan = value)
    }

    private fun updateShouldMakeDeviceVisible(value: Boolean) {
        state.value = state.value.copy(shouldMakeDeviceVisible = value)
    }

    private fun updateProgressBarState(value: ProgressBarState) {
        state.value = state.value.copy(progressBarState = value)
    }

    private fun updateIsBluetoothOn(value: Boolean) {
        state.value = state.value.copy(isBluetoothOn = value)
    }

    private fun addToSearchedDevice(item: DeviceData) {
        val currentSearchedDeviceList = state.value.searchedDevices
        currentSearchedDeviceList.add(item)
        state.value = state.value.copy(searchedDevices = currentSearchedDeviceList)
        Log.i(TAG, "addToSearchedDevice currentSearchedDeviceList: " + currentSearchedDeviceList)
    }

    private fun updateSearchedDevice(list: ArrayList<DeviceData>) {
        Log.i(TAG, "updateSearchedDevice list: " + list)
        state.value = state.value.copy(searchedDevices = list)
    }

    private fun updatePairedDevice(list: ArrayList<DeviceData>) {
        state.value = state.value.copy(pairedDevices = list)
    }


}