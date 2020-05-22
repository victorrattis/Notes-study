package com.vhra.study.notes.remote

import com.vhra.study.notes.remote.request.UserLoginRequest
import com.vhra.study.notes.remote.response.BaseResponse
import com.vhra.study.notes.remote.response.UserSessionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RestApi {
    @POST("login")
    fun login(
        @Body userLoginRequest: UserLoginRequest
    ): Call<BaseResponse<UserSessionResponse>>
}