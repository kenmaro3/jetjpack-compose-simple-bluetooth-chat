package com.example.simplebluetoothchat.business.constants.core

sealed class BluetoothConnectionState {

    object None : BluetoothConnectionState() { // we're doing nothing
        override fun toString(): String {
            return "None"
        }
    }


    object Connected : BluetoothConnectionState() {
        // now connected to a remote device
        override fun toString(): String {
            return "Connected"
        }
    }

}