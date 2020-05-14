package com.vhra.study.notes.ui.login

interface LoginContract {
    interface LoginView {
        fun getUserName(): String
        fun getUserPassword(): String
        fun openHomeScreen()
    }

    interface LoginPresenter {
        fun onLoginClicked()
    }
}