package com.example.simplebluetoothchat.business.interactors.transfer

import android.annotation.SuppressLint
import android.util.Log
import com.example.simplebluetoothchat.business.constants.BluetoothConstants
import com.example.simplebluetoothchat.business.constants.core.ConnectionState
import com.example.simplebluetoothchat.business.constants.core.DataState
import com.example.simplebluetoothchat.business.constants.core.ProgressBarState
import com.example.simplebluetoothchat.business.domain.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.OutputStream
import java.lang.Exception

class WriteTransferMessagesFromDevicesInteractor {

    val TAG = "AppDebug WriteTransferMessagesFromDevicesInteractor"

    @SuppressLint("MissingPermission", "LongLogTag")
    fun execute(
        buffer: ByteArray,
        outputStream: OutputStream,
    ): Flow<DataState<Message>> = flow {
        Log.i(TAG, "execute: ")
        try {

            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            outputStream.write(buffer)

            val msg = buffer.toCustomString()
            val milliSecondsTime = System.currentTimeMillis()
            val message = Message(message = msg ?: "", time = milliSecondsTime, type = BluetoothConstants.MESSAGE_TYPE_SENT)

            emit(DataState.Data(ConnectionState.Connected, message))

        } catch (e: Exception) {
            Log.i(TAG, "execute e: " + e.message)
            emit(DataState.Data(ConnectionState.Failed))
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}