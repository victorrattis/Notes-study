package com.vhra.study.notes.ui.login

import com.vhra.study.notes.domain.*
import com.vhra.study.notes.domain.usecase.LoginUserResponse
import com.vhra.study.notes.domain.usecase.LoginUserStatus
import com.vhra.study.notes.domain.usecase.UserDetail

class LoginPresenter(
    private val view: LoginContract.LoginView,
    private val loginUseCase: UseCase<UserDetail, LoginUserResponse>,
    private val connectivityUseCase: UseCase<Unit, Boolean>
) : LoginContract.LoginPresenter {
    override fun onLoginClicked() {
        connectivityUseCase.run(Unit, callback = { isConnected ->
            if (isConnected) {
                login()
            } else {
                view.showNoInternet()
            }
        })
    }

    private fun login() {
        val userName = view.getUserName()
        val userPassword = view.getUserPassword()

        loginUseCase.run(
            UserDetail(
                userName,
                userPassword
            ),
            callback = { response ->
                if (response.isAuthenticatedUser) {
                    view.openHomeScreen()
                } else {
                    showError(response.status)
                }
            })
    }

    private fun showError(status: LoginUserStatus) {
        when (status) {
            LoginUserStatus.EMPTY_USER_DETAIL_ERROR -> view.showEmptyInfoError()
            LoginUserStatus.UNAUTHENTICATED_USER_ERROR -> view.showUnauthUserError()
        }
    }
}