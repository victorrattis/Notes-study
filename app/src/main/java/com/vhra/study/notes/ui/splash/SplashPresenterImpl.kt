package com.vhra.study.notes.ui.splash

import com.vhra.study.notes.utils.TimeHandler

class SplashPresenterImpl constructor(
    private val view: SplashContract.SplashView,
    private val timeHandler: TimeHandler
) : SplashContract.SplashPresenter {

    override fun init() {
        timeHandler.callMe(1500, callback = {
            view.openLoginScreen()
        })
    }
}