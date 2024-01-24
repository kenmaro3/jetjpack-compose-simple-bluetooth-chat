package com.example.simplebluetoothchat.business.domain

data class Message(
    val message: String,
    val time: Long,
    val type: Int
)