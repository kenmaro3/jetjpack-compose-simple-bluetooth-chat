package com.example.simplebluetoothchat.di

import android.app.Application
import android.bluetooth.BluetoothAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideBluetoothAdapter(): BluetoothAdapter {
        return BluetoothAdapter.getDefaultAdapter()
    }

    @Singleton
    @Provides
    fun provideChatBluetoothManager(
        bluetoothAdapter: BluetoothAdapter,
        closeTransferMessagesFromDevicesInteractor: CloseTransferMessagesFromDevicesInteractor,
        initTransferMessagesFromDevicesInteractor: InitTransferMessagesFromDevicesInteractor,
        readTransferMessagesFromDevicesInteractor: ReadTransferMessagesFromDevicesInteractor,
        writeTransferMessagesFromDevicesInteractor: WriteTransferMessagesFromDevicesInteractor,
        closeToOtherDeviceInteractor: CloseToOtherDeviceInteractor,
        connectToOtherDeviceInteractor: ConnectToOtherDeviceInteractor,
        initConnectToOtherDeviceInteractor: InitConnectToOtherDeviceInteractor,
        acceptFromOtherDeviceInteractor: AcceptFromOtherDeviceInteractor,
        closeFromOtherDeviceInteractor: CloseFromOtherDeviceInteractor,
        initFromOtherDeviceInteractor: InitFromOtherDeviceInteractor,
    ): ChatBluetoothManager {
        return ChatBluetoothManager(
            bluetoothAdapter = bluetoothAdapter,
            closeTransferMessagesFromDevicesInteractor = closeTransferMessagesFromDevicesInteractor,
            initTransferMessagesFromDevicesInteractor = initTransferMessagesFromDevicesInteractor,
            readTransferMessagesFromDevicesInteractor = readTransferMessagesFromDevicesInteractor,
            writeTransferMessagesFromDevicesInteractor = writeTransferMessagesFromDevicesInteractor,
            closeToOtherDeviceInteractor = closeToOtherDeviceInteractor,
            connectToOtherDeviceInteractor = connectToOtherDeviceInteractor,
            initConnectToOtherDeviceInteractor = initConnectToOtherDeviceInteractor,
            acceptFromOtherDeviceInteractor = acceptFromOtherDeviceInteractor,
            closeFromOtherDeviceInteractor = closeFromOtherDeviceInteractor,
            initFromOtherDeviceInteractor = initFromOtherDeviceInteractor,
        )
    }
}