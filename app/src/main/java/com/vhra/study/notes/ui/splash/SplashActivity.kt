package com.vhra.study.notes.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vhra.study.notes.R
import com.vhra.study.notes.ui.login.LoginActivity
import com.vhra.study.notes.utils.TimeHandler

class SplashActivity : AppCompatActivity(), SplashContract.SplashView {
    private lateinit var presenter: SplashContract.SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenterImpl(this, TimeHandler())
        presenter.init()
    }

    override fun openLoginScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
