package com.example.simplebluetoothchat.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BluetoothModule {

    @Singleton
    @Provides
    fun provideCloseTransferMessagesFromDevicesInteractor(): CloseTransferMessagesFromDevicesInteractor {
        return CloseTransferMessagesFromDevicesInteractor()
    }

    @Singleton
    @Provides
    fun provideInitTransferMessagesFromDevicesInteractor(): InitTransferMessagesFromDevicesInteractor {
        return InitTransferMessagesFromDevicesInteractor()
    }

    @Singleton
    @Provides
    fun provideReadTransferMessagesFromDevicesInteractor(): ReadTransferMessagesFromDevicesInteractor {
        return ReadTransferMessagesFromDevicesInteractor()
    }

    @Singleton
    @Provides
    fun provideWriteTransferMessagesFromDevicesInteractor(): WriteTransferMessagesFromDevicesInteractor {
        return WriteTransferMessagesFromDevicesInteractor()
    }

    @Singleton
    @Provides
    fun provideCloseToOtherDeviceInteractor(): CloseToOtherDeviceInteractor {
        return CloseToOtherDeviceInteractor()
    }

    @Singleton
    @Provides
    fun provideConnectToOtherDeviceInteractor(): ConnectToOtherDeviceInteractor {
        return ConnectToOtherDeviceInteractor()
    }

    @Singleton
    @Provides
    fun provideInitConnectToOtherDeviceInteractor(): InitConnectToOtherDeviceInteractor {
        return InitConnectToOtherDeviceInteractor()
    }

    @Singleton
    @Provides
    fun provideAcceptFromOtherDeviceInteractor(): AcceptFromOtherDeviceInteractor {
        return AcceptFromOtherDeviceInteractor()
    }

    @Singleton
    @Provides
    fun provideCloseFromOtherDeviceInteractor(): CloseFromOtherDeviceInteractor {
        return CloseFromOtherDeviceInteractor()
    }

    @Singleton
    @Provides
    fun provideInitFromOtherDeviceInteractor(): InitFromOtherDeviceInteractor {
        return InitFromOtherDeviceInteractor()
    }


}