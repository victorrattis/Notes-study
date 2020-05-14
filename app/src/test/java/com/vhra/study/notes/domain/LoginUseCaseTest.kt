package com.vhra.study.notes.domain

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito

inline fun<reified T: Any> mock(): T = Mockito.mock(T::class.java)

class TestAuthUserService(
    private val name: String,
    private val password: String
) : AuthUserService {
    override fun login(
        userName: String,
        userPassword: String,
        callback: (AuthUserSession?) -> Unit
    ) {
        if (userName == name && userPassword == password) {
            callback(AuthUserSession("007", "sadjhasdkjhasd"))
        } else {
            callback(null)
        }
    }
}

class LoginUseCaseTest {
    @Test
    fun `should return empty user detail when the empty user name and password`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserService = Mockito.mock(AuthUserService::class.java)

        val loginUseCase = LoginUseCase(authUserService)
        loginUseCase.run(UserDetail("", ""), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.EMPTY_USER_DETAIL_ERROR
            ))
    }

    @Test
    fun `should return empty error when the empty password only`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserService = Mockito.mock(AuthUserService::class.java)

        val loginUseCase = LoginUseCase(authUserService)
        loginUseCase.run(UserDetail("user 1", ""), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.EMPTY_USER_DETAIL_ERROR
            ))
    }

    @Test
    fun `should return empty error when the empty user name only`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserService = Mockito.mock(AuthUserService::class.java)

        val loginUseCase = LoginUseCase(authUserService)
        loginUseCase.run(UserDetail("", "1234"), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.EMPTY_USER_DETAIL_ERROR
            ))
    }

    @Test
    fun `should return unauthenticated user when the invalid user and password`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserService = TestAuthUserService("admin", "1234")

        val loginUseCase = LoginUseCase(authUserService)
        loginUseCase.run(UserDetail("user 1", "1234"), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.UNAUTHENTICATED_USER_ERROR
            ))
    }

    @Test
    fun `should return authenticated user when the valid user and password`() {
        val callback: (LoginUserResponse) -> Unit = mock()

        val loginUseCase = LoginUseCase(TestAuthUserService("admin", "1234"))
        loginUseCase.run(UserDetail("admin", "1234"), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                true,
                LoginUserStatus.AUTHENTICATED_USER
            ))
    }
}