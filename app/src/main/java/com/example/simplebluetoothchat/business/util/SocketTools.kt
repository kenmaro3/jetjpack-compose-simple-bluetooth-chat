package com.example.simplebluetoothchat.business.util

import com.example.simplebluetoothchat.business.constants.BluetoothConstants.BLUETOOTH_SOCKET_TYPE_INSECURE
import com.example.simplebluetoothchat.business.constants.BluetoothConstants.BLUETOOTH_SOCKET_TYPE_SECURE
import java.nio.charset.Charset

object SocketTools {

    fun Boolean.getSocketType():String = if (this) BLUETOOTH_SOCKET_TYPE_SECURE else BLUETOOTH_SOCKET_TYPE_INSECURE

    fun ByteArray.toCustomString()= this.toString(Charset.defaultCharset())

}