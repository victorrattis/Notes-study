package com.vhra.study.notes.domain

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