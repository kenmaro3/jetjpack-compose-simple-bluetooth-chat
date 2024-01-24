package com.example.simplebluetoothchat.business.util

import com.example.simplebluetoothchat.business.constants.BluetoothConstants.MESSAGE_TYPE_RECEIVED
import com.example.simplebluetoothchat.business.constants.BluetoothConstants.MESSAGE_TYPE_SENT
import com.example.simplebluetoothchat.business.domain.Message
import java.text.SimpleDateFormat
import java.util.*

object MessageTools {

    fun Int.convertToString():String{
        if (this == MESSAGE_TYPE_SENT) return "You"
        if (this == MESSAGE_TYPE_RECEIVED) return "User"
        return "Unknown"
    }



    fun Long.convertToString(): String {
        val df: SimpleDateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())

        val resultdate = Date(this)

        return df.format(resultdate)
    }

    private val MIN_SIZE_TO_REVERSE = 10


    fun List<Message>.shouldReverseList() = this.size > MIN_SIZE_TO_REVERSE

    fun List<Message>.sortMessagesByCount() = if (this.size < MIN_SIZE_TO_REVERSE) this.reversed() else this


}