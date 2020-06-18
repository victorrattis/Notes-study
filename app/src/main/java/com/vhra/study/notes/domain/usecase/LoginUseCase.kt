package com.vhra.study.notes.domain.usecase

import com.vhra.study.notes.domain.AuthUserLocalDataSource
import com.vhra.study.notes.domain.AuthUserService
import com.vhra.study.notes.domain.UseCase

class LoginUseCase(
    private val authUserService: AuthUserService,
    private val authUserLocalDataSource: AuthUserLocalDataSource
) : UseCase<UserDetail, LoginUserResponse> {
    override fun run(input: UserDetail, callback: (LoginUserResponse) -> Unit) {
        if (input.userName.isEmpty() || input.userPassword.isEmpty()) {
            callback(
                LoginUserResponse(
                    false,
                    LoginUserStatus.EMPTY_USER_DETAIL_ERROR
                )
            )
            return
        }

        authUserService.login(
            input.userName,
            input.userPassword,
            callback = { authUserSession ->
                if (authUserSession != null) {
                    authUserLocalDataSource.save(authUserSession)
                    callback(
                        LoginUserResponse(
                            true,
                            LoginUserStatus.AUTHENTICATED_USER
                        )
                    )
                } else {
                    callback(
                        LoginUserResponse(
                            false,
                            LoginUserStatus.UNAUTHENTICATED_USER_ERROR
                        )
                    )
                }
            })
    }
}

data class UserDetail(
    val userName: String,
    val userPassword: String
)

enum class LoginUserStatus {
    AUTHENTICATED_USER,
    EMPTY_USER_DETAIL_ERROR,
    UNAUTHENTICATED_USER_ERROR
}

data class LoginUserResponse(
    val isAuthenticatedUser: Boolean,
    val status: LoginUserStatus
)