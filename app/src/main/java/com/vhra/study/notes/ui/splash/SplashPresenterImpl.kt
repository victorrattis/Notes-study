package com.vhra.study.notes.ui.splash

import com.vhra.study.notes.domain.UseCase
import com.vhra.study.notes.domain.usecase.InitAppResponse
import com.vhra.study.notes.utils.TimeHandler

class SplashPresenterImpl constructor(
    private val view: SplashContract.SplashView,
    private val initAppUseCase: UseCase<Unit, InitAppResponse>
) : SplashContract.SplashPresenter {
    override fun init() {
        initAppUseCase.run(
            Unit, callback = { response ->
                when(response) {
                    InitAppResponse.HOME_SCREEN ->  view.openHomeScreen()
                    InitAppResponse.LOGIN_SCREEN -> view.openLoginScreen()
                }
            }
        )
    }
}