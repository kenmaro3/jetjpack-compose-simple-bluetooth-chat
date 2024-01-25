package com.example.simplebluetoothchat.business.interactors.connect_to_other_device

import android.annotation.SuppressLint
import android.bluetooth.BluetoothSocket
import android.util.Log
import com.example.simplebluetoothchat.business.constants.core.ConnectionState
import com.example.simplebluetoothchat.business.constants.core.DataState
import com.example.simplebluetoothchat.business.constants.core.ProgressBarState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class CloseToOtherDeviceInteractor {

    val TAG = "AppDebug CloseToOtherDeviceInteractor"

    @SuppressLint("MissingPermission", "LongLogTag")
    fun execute(bluetoothSocket: BluetoothSocket) : Flow<DataState<ConnectionState>> = flow{
        Log.i(TAG, "connect: ")
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            bluetoothSocket.close()

            emit(DataState.Data(ConnectionState.Closed))

        } catch (e: Exception) {
            Log.i(TAG, "execute e: " + e.message)
            emit(DataState.Data(ConnectionState.Failed))
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }


}