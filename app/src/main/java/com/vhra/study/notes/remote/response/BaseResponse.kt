package com.vhra.study.notes.remote.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("statusCode") val status: String,
    @SerializedName("data") val data: T,
    @SerializedName("error") val errorMessage: String
)