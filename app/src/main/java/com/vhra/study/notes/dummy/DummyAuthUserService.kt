package com.vhra.study.notes.dummy

import com.vhra.study.notes.domain.AuthUserService
import com.vhra.study.notes.domain.AuthUserSession

class DummyAuthUserService : AuthUserService {
    override fun login(
        userName: String,
        userPassword: String,
        callback: (AuthUserSession?) -> Unit
    ) {

    }
}