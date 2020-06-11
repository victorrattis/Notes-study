package com.vhra.study.notes.device

import com.vhra.study.notes.domain.IConnectivityController

class QDeviceConnectivityController : IConnectivityController {
    override fun hasInternetConnected(): Boolean {
        return true
    }
}