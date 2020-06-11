package com.vhra.study.notes.device

import android.content.Context
import com.vhra.study.notes.domain.IConnectivityController

object DeviceConnFactory {
    fun createConnectivityController(context: Context): IConnectivityController {
        return DeviceConnectivityController(context)
    }
}