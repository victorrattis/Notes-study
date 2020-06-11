package com.vhra.study.notes.device

import android.content.Context
import android.net.ConnectivityManager
import com.vhra.study.notes.domain.IConnectivityController

class DeviceConnectivityController (
    private val context: Context
) : IConnectivityController {
    override fun hasInternetConnected(): Boolean {
        val connectivityManager = context.applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetworkInfo
        return network != null && network.isConnected
    }
}