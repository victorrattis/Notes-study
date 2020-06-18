package com.vhra.study.notes.domain

import com.vhra.study.notes.domain.usecase.LoginUseCase
import com.vhra.study.notes.domain.usecase.LoginUserResponse
import com.vhra.study.notes.domain.usecase.LoginUserStatus
import com.vhra.study.notes.domain.usecase.UserDetail
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
        val authUserRepository = Mockito.mock(AuthUserLocalDataSource::class.java)

        val loginUseCase =
            LoginUseCase(authUserService, authUserRepository)
        loginUseCase.run(UserDetail("", ""), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.EMPTY_USER_DETAIL_ERROR
            )
        )
    }

    @Test
    fun `should return empty error when the empty password only`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserService = Mockito.mock(AuthUserService::class.java)
        val authUserRepository = Mockito.mock(AuthUserLocalDataSource::class.java)

        val loginUseCase =
            LoginUseCase(authUserService, authUserRepository)
        loginUseCase.run(
            UserDetail(
                "user 1",
                ""
            ), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.EMPTY_USER_DETAIL_ERROR
            )
        )
    }

    @Test
    fun `should return empty error when the empty user name only`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserService = Mockito.mock(AuthUserService::class.java)
        val authUserRepository = Mockito.mock(AuthUserLocalDataSource::class.java)

        val loginUseCase =
            LoginUseCase(authUserService, authUserRepository)
        loginUseCase.run(
            UserDetail(
                "",
                "1234"
            ), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.EMPTY_USER_DETAIL_ERROR
            )
        )
    }

    @Test
    fun `should return unauthenticated user when the invalid user and password`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserService = TestAuthUserService("admin", "1234")
        val authUserRepository = Mockito.mock(AuthUserLocalDataSource::class.java)

        val loginUseCase =
            LoginUseCase(authUserService, authUserRepository)
        loginUseCase.run(
            UserDetail(
                "user 1",
                "1234"
            ), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                false,
                LoginUserStatus.UNAUTHENTICATED_USER_ERROR
            )
        )
    }

    @Test
    fun `should return authenticated user when the valid user and password`() {
        val callback: (LoginUserResponse) -> Unit = mock()
        val authUserRepository = Mockito.mock(AuthUserLocalDataSource::class.java)

        val loginUseCase = LoginUseCase(
            TestAuthUserService(
                "admin",
                "1234"
            ),
            authUserRepository
        )
        loginUseCase.run(
            UserDetail(
                "admin",
                "1234"
            ), callback)

        Mockito.verify(callback).invoke(
            LoginUserResponse(
                true,
                LoginUserStatus.AUTHENTICATED_USER
            )
        )
    }
}