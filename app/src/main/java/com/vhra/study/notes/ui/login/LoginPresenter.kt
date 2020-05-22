package com.vhra.study.notes.ui.login

import com.vhra.study.notes.domain.*
import java.util.concurrent.Executor

class LoginPresenter(
    private val view: LoginContract.LoginView,
    private val loginUseCase: UseCase<UserDetail, LoginUserResponse>
) : LoginContract.LoginPresenter {
    override fun onLoginClicked() {
        val userName = view.getUserName()
        val userPassword = view.getUserPassword()

        loginUseCase.run(
            UserDetail(userName, userPassword),
            callback = { response ->
                if (response.isAuthenticatedUser) {
                    view.openHomeScreen()
                } else {
                    showError(response.status)
                }
            })
    }

    private fun showError(status: LoginUserStatus) {
        view.showError()
    }
}