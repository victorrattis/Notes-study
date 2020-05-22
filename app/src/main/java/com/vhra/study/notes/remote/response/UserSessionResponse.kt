package com.vhra.study.notes.remote.response

import com.google.gson.annotations.SerializedName
import com.vhra.study.notes.remote.response.UserDetailResponse

data class UserSessionResponse(
    @SerializedName("user") val user: UserDetailResponse,
    @SerializedName("token") val token: String
)