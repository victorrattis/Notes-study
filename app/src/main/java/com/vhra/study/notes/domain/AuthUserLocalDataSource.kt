package com.vhra.study.notes.domain

interface AuthUserLocalDataSource {
    fun save(authUserSession: AuthUserSession)
    fun hasUserSession(callback: (Boolean) -> Unit)
}