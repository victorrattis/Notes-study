package com.vhra.study.notes.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.vhra.study.notes.R
import com.vhra.study.notes.data.local.SharedPreferenceUserDataSource
import com.vhra.study.notes.device.DeviceConnFactory
import com.vhra.study.notes.device.DeviceWifiController
import com.vhra.study.notes.domain.usecase.CheckIntentConnectionUseCase
import com.vhra.study.notes.domain.usecase.LoginUseCase
import com.vhra.study.notes.remote.RemoveAuthUserService
import com.vhra.study.notes.remote.RestWebService
import com.vhra.study.notes.ui.home.HomeActivity

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {
    private lateinit var presenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(
            this,
            LoginUseCase(
                RemoveAuthUserService(RestWebService().api),
                SharedPreferenceUserDataSource(this)
            ),
            CheckIntentConnectionUseCase(
                DeviceWifiController(this),
                DeviceConnFactory.createConnectivityController(this)
            )
        )

        findViewById<Button>(R.id.button_login)?.setOnClickListener {
            presenter.onLoginClicked()
        }
    }

    override fun getUserName(): String = findViewById<EditText>(R.id.edit_user_name).text.toString()
    override fun getUserPassword(): String = findViewById<EditText>(R.id.edit_user_password).text.toString()

    override fun openHomeScreen() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun showError() {
        Toast.makeText(this, "Login Error!!!", Toast.LENGTH_LONG).show()
    }

    override fun showEmptyInfoError() {
        Toast.makeText(
            this,
            getString(R.string.text_empty_user_info_error),
            Toast.LENGTH_LONG).show()
    }

    override fun showUnauthUserError() {
        Toast.makeText(
            this,
            getString(R.string.text_unauthenticated_user_error),
            Toast.LENGTH_LONG).show()
    }

    override fun showNoInternet() {
        Toast.makeText(
            this,
            getString(R.string.text_no_internet_error),
            Toast.LENGTH_LONG).show()
    }
}
