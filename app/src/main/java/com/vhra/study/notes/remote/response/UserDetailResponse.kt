package com.vhra.study.notes.remote.response

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("userName") val name: String
)