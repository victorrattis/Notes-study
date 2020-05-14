package com.vhra.study.notes.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.vhra.study.notes.DummyAuthUserService
import com.vhra.study.notes.R
import com.vhra.study.notes.domain.LoginUseCase
import com.vhra.study.notes.utils.UseCaseRunner

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {
    private lateinit var presenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(
            this,
            LoginUseCase(DummyAuthUserService())
        )

        findViewById<Button>(R.id.button_login)?.setOnClickListener {
            presenter.onLoginClicked()
        }
    }

    override fun getUserName(): String = findViewById<EditText>(R.id.edit_user_name).text.toString()
    override fun getUserPassword(): String = findViewById<EditText>(R.id.edit_user_name).text.toString()

    override fun openHomeScreen() {

    }
}
