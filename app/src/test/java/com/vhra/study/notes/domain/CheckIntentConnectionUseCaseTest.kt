package com.vhra.study.notes.domain

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito


class CheckIntentConnectionUseCaseTest {

    @Test
    fun `should return false when wifi option is disabled`() {
        val callback: (Boolean) -> Unit = mock()
        val connectivityController = Mockito.mock(IConnectivityController::class.java)
        val wifiController: IWifiController = Mockito.mock(IWifiController::class.java)
        Mockito.`when`(wifiController.isWifiOptionEnabled()).thenReturn(false)

        CheckIntentConnectionUseCase(wifiController, connectivityController).run(Unit, callback)

        Mockito.verify(callback).invoke(false)
    }

    @Test
    fun `should return true when wifi option is enabled and has connection`() {
        val callback: (Boolean) -> Unit = mock()
        val connectivityController = Mockito.mock(IConnectivityController::class.java)
        val wifiController: IWifiController = Mockito.mock(IWifiController::class.java)
        Mockito.`when`(wifiController.isWifiOptionEnabled()).thenReturn(true)
        Mockito.`when`(connectivityController.hasInternetConnected()).thenReturn(true)

        CheckIntentConnectionUseCase(wifiController, connectivityController).run(Unit, callback)

        Mockito.verify(callback).invoke(true)
    }

    @Test
    fun `should return false when wifi option is enabled and no connection`() {
        val callback: (Boolean) -> Unit = mock()
        val connectivityController = Mockito.mock(IConnectivityController::class.java)
        val wifiController: IWifiController = Mockito.mock(IWifiController::class.java)
        Mockito.`when`(wifiController.isWifiOptionEnabled()).thenReturn(true)
        Mockito.`when`(connectivityController.hasInternetConnected()).thenReturn(false)

        CheckIntentConnectionUseCase(wifiController, connectivityController).run(Unit, callback)

        Mockito.verify(callback).invoke(false)
    }
}