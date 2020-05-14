package com.vhra.study.notes.domain

interface AuthUserService {
    fun login(userName: String, userPassword: String, callback: (AuthUserSession?) -> Unit)
}