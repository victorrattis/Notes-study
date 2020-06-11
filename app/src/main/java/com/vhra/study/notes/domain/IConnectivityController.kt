package com.vhra.study.notes.domain

interface IConnectivityController {
    abstract fun hasInternetConnected(): Boolean
}