package com.vhra.study.notes.ui.login

interface LoginContract {
    interface LoginView {
        fun getUserName(): String
        fun getUserPassword(): String
        fun openHomeScreen()
        fun showError()
        fun showEmptyInfoError()
        fun showUnauthUserError()
        fun showNoInternet()
    }

    interface LoginPresenter {
        fun onLoginClicked()
    }
}