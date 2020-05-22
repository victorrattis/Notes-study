package com.vhra.study.notes.remote.request

import com.google.gson.annotations.SerializedName

data class UserLoginRequest(
    @SerializedName("userName") val userName: String,
    @SerializedName("password") val userPassword: String
)