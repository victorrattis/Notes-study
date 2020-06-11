package com.vhra.study.notes.device

import android.content.Context
import android.net.wifi.WifiManager
import com.vhra.study.notes.domain.IWifiController

class DeviceWifiController(
    private val context: Context
) : IWifiController {

    override fun isWifiOptionEnabled() =
        (context.applicationContext.getSystemService(
            Context.WIFI_SERVICE) as WifiManager).isWifiEnabled

}