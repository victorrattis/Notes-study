package com.vhra.study.notes.domain.usecase

import com.vhra.study.notes.domain.AuthUserLocalDataSource
import com.vhra.study.notes.domain.UseCase
import com.vhra.study.notes.utils.TimeHandler

class InitializeAppUseCase constructor(
    private val timeHandler: TimeHandler,
    private val authUserLocalDataSource: AuthUserLocalDataSource
): UseCase<Unit, InitAppResponse> {
    override fun run(input: Unit, callback: (InitAppResponse) -> Unit) {
        timeHandler.callMe(1500, callback = {
            authUserLocalDataSource.hasUserSession(callback = { hasLoggedUser ->
                if (hasLoggedUser) { callback(InitAppResponse.HOME_SCREEN) }
                else { callback(InitAppResponse.LOGIN_SCREEN) }
            })
        })
    }
}

enum class InitAppResponse {
    LOGIN_SCREEN,
    HOME_SCREEN
}