package com.vhra.study.notes.domain.usecase

import com.vhra.study.notes.domain.IConnectivityController
import com.vhra.study.notes.domain.IWifiController
import com.vhra.study.notes.domain.UseCase

class CheckIntentConnectionUseCase(
    private val wifiController: IWifiController,
    private val connectivityController: IConnectivityController
) : UseCase<Unit, Boolean> {
    override fun run(input: Unit, callback: (Boolean) -> Unit) {
        if (!wifiController.isWifiOptionEnabled()) {
            callback(false)
        } else if (!connectivityController.hasInternetConnected()) {
            callback(false)
        } else {
            callback(true)
        }
    }
}