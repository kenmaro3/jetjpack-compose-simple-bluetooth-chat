package com.example.simplebluetoothchat.presentation.bluetooth_manager


import android.bluetooth.BluetoothSocket
import com.example.simplebluetoothchat.business.constants.BluetoothConstants.DEFAULT_INPUT_STREAM
import com.example.simplebluetoothchat.business.constants.BluetoothConstants.DEFAULT_OUTPUT_STREAM
import com.example.simplebluetoothchat.business.constants.core.BluetoothConnectionState
import com.example.simplebluetoothchat.business.constants.core.Dialog
import com.example.simplebluetoothchat.business.constants.core.ProgressBarState
import com.example.simplebluetoothchat.business.constants.core.Queue
import com.example.simplebluetoothchat.business.domain.Message
import java.io.InputStream
import java.io.OutputStream

data class BluetoothManagerState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val bluetoothConnectionState: BluetoothConnectionState = BluetoothConnectionState.None,
    val messagesList: ArrayList<Message> = arrayListOf(),
    val errorQueue: Queue<Dialog> = Queue(mutableListOf()),
    val outputStream: OutputStream = DEFAULT_OUTPUT_STREAM,
    val inputStream: InputStream = DEFAULT_INPUT_STREAM,
    val activeBluetoothSocket: BluetoothSocket?=null // be careful with that
)